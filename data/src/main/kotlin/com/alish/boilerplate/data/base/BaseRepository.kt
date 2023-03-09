package com.alish.boilerplate.data.base

import android.util.Log
import android.webkit.MimeTypeMap
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.utils.NetworkError
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File

/**
 * Base class for all repository implements with helper data layer functions
 *
 * @author Alish
 */
abstract class BaseRepository {

    /**
     * Do network request with [DataMapper.mapToDomain]
     *
     * @receiver [doNetworkRequest]
     */
    protected fun <T : DataMapper<S>, S> doNetworkRequestWithMapping(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, S>> = doNetworkRequest(request) { body ->
        Either.Right(body.mapToDomain())
    }

    /**
     * Do network request without mapping for primitive types
     *
     * @receiver [doNetworkRequest]
     */
    protected fun <T> doNetworkRequestWithoutMapping(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, T>> = doNetworkRequest(request) { body ->
        Either.Right(body)
    }

    /**
     * Do network request for [Response] with [List]
     *
     * @receiver [doNetworkRequest]
     */
    protected fun <T : DataMapper<S>, S> doNetworkRequestForList(
        request: suspend () -> Response<List<T>>
    ): Flow<Either<NetworkError, List<S>>> = doNetworkRequest(request) { body ->
        Either.Right(body.map { it.mapToDomain() })
    }

    /**
     * Base function for do network requests
     *
     * @param request http request function from api service
     * @param successful handle response body with custom mapping
     *
     * @return [NetworkError] or [Response.body] in [Flow] with [Either]
     *
     * @see [Response]
     * @see [Flow]
     * @see [Either]
     * @see [NetworkError]
     */
    private fun <T, S> doNetworkRequest(
        request: suspend () -> Response<T>,
        successful: (T) -> Either.Right<S>
    ) = flow {
        request().let {
            when {
                it.isSuccessful && it.body() != null -> {
                    emit(successful.invoke(it.body()!!))
                }
                !it.isSuccessful && it.code() == 422 -> {
                    emit(Either.Left(NetworkError.ApiInputs(it.errorBody().toApiError())))
                }
                else -> {
                    emit(Either.Left(NetworkError.Api(it.errorBody().toApiError())))
                }
            }
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        val message = exception.localizedMessage ?: "Error Occurred!"
        if (BuildConfig.DEBUG) Log.d(this@BaseRepository.javaClass.simpleName, message)
        emit(Either.Left(NetworkError.Unexpected(message)))
    }

    /**
     * Convert network error from server side
     *
     * @receiver [ResponseBody]
     * @see Response.errorBody
     * @see Gson.fromJson
     */
    private inline fun <reified T> ResponseBody?.toApiError(): T {
        return Gson().fromJson(
            this?.string(), object : TypeToken<T>() {}.type
        )
    }

    /**
     * Get non-nullable body from network request
     *
     * &nbsp
     *
     * ## How to use:
     * ```
     * override fun fetchFoo() = doNetworkRequestWithMapping {
     *     service.fetchFoo().onSuccess { data ->
     *         make something with data
     *     }
     * }
     * ```
     *
     * @see Response.body
     * @see let
     */
    protected inline fun <T : Response<S>, S> T.onSuccess(block: (S) -> Unit): T {
        this.body()?.let(block)
        return this
    }

    /**
     * Convert [File] to [MultipartBody.Part]
     *
     * &nbsp
     *
     * ## How to use:
     * ```
     * override fun uploadAvatar(avatar: String) = doNetworkRequest {
     *     val file = File(Uri.parse(avatar).path!!)
     *     service.uploadAvatar(file.toMultipartBodyPart("avatar"))
     * }
     * ```
     *
     * @receiver [File]
     *
     * @param formDataName set name for [MultipartBody.Part.createFormData]
     *
     * @return [MultipartBody.Part]
     *
     * @see asRequestBody
     * @see MimeTypeMap
     * @see toMediaTypeOrNull
     */
    protected fun File.toMultipartBodyPart(
        formDataName: String
    ) = MultipartBody.Part.createFormData(
        name = formDataName,
        filename = name,
        body = asRequestBody(
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)?.toMediaTypeOrNull()
        )
    )

    /**
     * Do network paging request with default params
     *
     * &nbsp
     *
     * ## How to use:
     * ```
     * override fun fetchFooPaging() = doPagingRequest({ FooPagingSource(service) })
     * ```
     *
     * @see BasePagingSource
     */
    protected fun <ValueDto : DataMapper<Value>, Value : Any, PagingSource : BasePagingSource<ValueDto, Value>> doPagingRequest(
        pagingSource: () -> PagingSource,
        pageSize: Int = 10,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE
    ): Flow<PagingData<Value>> {
        return Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enablePlaceholders,
                initialLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = {
                pagingSource()
            }
        ).flow
    }

    /**
     * Do request to local database with [DataMapper.mapToDomain]
     *
     * @param request function for request to database
     */
    fun <T : DataMapper<S>, S> doLocalRequest(
        request: () -> Flow<List<T>>
    ): Flow<List<S>> = request().map { list -> list.map { data -> data.mapToDomain() } }
}