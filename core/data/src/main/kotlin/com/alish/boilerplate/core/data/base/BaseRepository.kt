package com.alish.boilerplate.core.data.base

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.core.data.utils.DataMapper
import com.alish.boilerplate.core.data.utils.toApiError
import com.alish.boilerplate.core.domain.Either
import com.alish.boilerplate.core.domain.NetworkError
import com.alish.boilerplate.core.domain.RemoteWrapper
import com.alish.boilerplate.core.domain.mapList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.io.InterruptedIOException

/**
 * Base class for all repository implements with helper data layer functions
 *
 * @author Alish
 */
abstract class BaseRepository(
    val ioDispatcher: CoroutineDispatcher
) {

    /**
     * Perform a network request and map the response using the provided mapper function.
     *
     * @param request The suspend function representing the network request.
     * @return A [flow] emitting [Either] a [NetworkError] or the mapped [response object][T].
     *
     * @see doNetworkRequest
     */
    protected fun <T : DataMapper<S>, S> networkFlow(
        request: suspend () -> Response<T>
    ): RemoteWrapper<S> = doNetworkRequest(request) { responseBody ->
        responseBody.toDomain()
    }

    /**
     * Perform a network request without mapping for primitive types.
     *
     * @param request The suspend function representing the network request.
     * @return A [flow] emitting [Either] a [NetworkError] or the [response body][T].
     *
     * @see doNetworkRequest
     */
    protected fun <T> networkFlowRaw(
        request: suspend () -> Response<T>
    ): RemoteWrapper<T> = doNetworkRequest(request) { responseBody ->
        responseBody
    }

    /**
     * Perform a network request for a list response and map each item using the provided mapper function.
     *
     * @param request The suspend function representing the network request.
     * @return A [flow] emitting [Either] a [NetworkError] or the list of mapped [response objects][T].
     *
     * @see doNetworkRequest
     */
    protected fun <T : DataMapper<S>, S> networkFlowList(
        request: suspend () -> Response<List<T>>
    ): RemoteWrapper<List<S>> = doNetworkRequest(request) { responseBody ->
        responseBody.map { it.toDomain() }
    }

    /**
     * Perform a network request that does not expect any response body and returns [Unit].
     *
     * @param request The suspend function representing the network request.
     * @return A [flow] emitting [Either] a [NetworkError] or [Unit].
     *
     * @see doNetworkRequest
     */
    protected fun <T> networkFlowUnit(
        request: suspend () -> Response<T>
    ): RemoteWrapper<Unit> = doNetworkRequest(request) {}

    /**
     * Base function for performing network requests and handling responses.
     *
     * @param T The type of the response body - data layer model (DTO).
     * @param S The type of the domain model.
     * @param request The suspend function representing the network http request.
     * @param successful The function to handle successful responses and map the response body.
     * @return A [flow] emitting [Either] a [NetworkError] or the mapped [response object][T].
     *
     * @see [Flow]
     * @see [Either]
     * @see [NetworkError]
     * @see [toApiError]
     */
    private fun <T, S> doNetworkRequest(
        request: suspend () -> Response<T>,
        successful: (T) -> S
    ) = flow {
        val response = request()
        when {
            response.isSuccessful -> {
                val body = response.body()

                if (body != null) {
                    emit(Either.Right(successful.invoke(body)))
                } else {
                    emit(Either.Left(NetworkError.Unexpected("Body is null WTF?")))
                }
            }

            !response.isSuccessful && response.code() == 422 -> {
                emit(Either.Left(NetworkError.ApiInputs(response.errorBody().toApiError())))
            }

            else -> {
                emit(Either.Left(NetworkError.Api(response.errorBody().toApiError())))
            }
        }
    }.flowOn(ioDispatcher).catch { exception ->
        when (exception) {
            is InterruptedIOException -> {
                emit(Either.Left(NetworkError.Timeout))
            }

            // ...

            else -> {
                val message = exception.localizedMessage ?: "Unexpected Error! (check BaseRepo)"
                if (BuildConfig.DEBUG) Log.e("BaseRepository", message)
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
     * override fun fetchFooPaging() = pagingFlow {
     *     FooPagingSource(service)
     * }
     *
     * // or
     *
     * override fun fetchFooPaging() = pagingFlow(
     *     pagingConfig = PagingConfig(...),
     *     pagingSource = { FooPagingSource(service) }
     * )
     * ```
     *
     * @see BasePagingSource
     */
    protected fun <ValueDto : DataMapper<Value>, Value : Any> pagingFlow(
        pagingConfig: PagingConfig = PagingConfig(pageSize = 10),
        pagingSource: () -> BasePagingSource<ValueDto, Value>
    ): Flow<PagingData<Value>> = Pager(
        config = pagingConfig,
        pagingSourceFactory = pagingSource
    ).flow

    /**
     * Do request to local database with [DataMapper.toDomain]
     *
     * @param request high-order function for request to database
     */
    protected fun <T : DataMapper<S>, S> dbFlow(
        request: () -> Flow<T>
    ): Flow<S> = request().map { data -> data.toDomain() }

    /**
     * Do request to local database with [DataMapper.toDomain] for [List]
     *
     * @param request high-order function for request to database
     */
    protected fun <T : DataMapper<S>, S> dbFlowList(
        request: () -> Flow<List<T>>
    ): Flow<List<S>> = request().mapList { data -> data.toDomain() }
}