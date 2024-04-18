package com.alish.boilerplate.data.core.base

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.data.core.utils.toApiError
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.domain.core.NetworkError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.io.InterruptedIOException

/**
 * Base class for all repository implements with helper data layer functions
 *
 * @author Alish
 */
abstract class BaseRepository {

    /**
     * Do network request with [toDomain][DataMapper.toDomain]
     *
     * @receiver [doNetworkRequest]
     */
    protected fun <T : DataMapper<S>, S> doNetworkRequestWithMapping(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, S>> = doNetworkRequest(request) { body ->
        Either.Right(body.toDomain())
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
        Either.Right(body.map { it.toDomain() })
    }

    /**
     * Do network request for and return [Unit]
     *
     * @receiver [doNetworkRequest]
     */
    protected fun <T> doNetworkRequestUnit(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, Unit>> = doNetworkRequest(request) {
        Either.Right(Unit)
    }

    /**
     * Base function for do network requests
     *
     * @param T data layer model (DTO)
     * @param S domain layer model
     * @param request http request function from api service
     * @param successful handle response body with custom mapping
     *
     * @return [NetworkError] or [body][Response.body] in [Flow] with [Either]
     *
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
        when (exception) {
            is InterruptedIOException -> {
                emit(Either.Left(NetworkError.Timeout))
            }

            else -> {
                val message = exception.localizedMessage ?: "Error Occurred!"
                if (BuildConfig.DEBUG) Log.d(this@BaseRepository.javaClass.simpleName, message)
                emit(Either.Left(NetworkError.Unexpected(message)))
            }
        }
    }

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
     * Do request to local database with [DataMapper.toDomain]
     *
     * @param request high-order function for request to database
     */
    protected fun <T : DataMapper<S>, S> doLocalRequest(
        request: () -> Flow<T>
    ): Flow<S> = request().map { data -> data.toDomain() }

    /**
     * Do request to local database with [DataMapper.toDomain] for [List]
     *
     * @param request high-order function for request to database
     */
    protected fun <T : DataMapper<S>, S> doLocalRequestForList(
        request: () -> Flow<List<T>>
    ): Flow<List<S>> = request().map { list -> list.map { data -> data.toDomain() } }
}