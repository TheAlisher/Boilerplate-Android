package com.alish.boilerplate.core.data.base

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.core.data.utils.DataMapper
import com.alish.boilerplate.core.data.utils.toApiError
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.domain.core.mapList
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
     * Perform a network request and map the response using the provided mapper function.
     *
     * @param request The suspend function representing the network request.
     * @return A [flow] emitting [Either] a [NetworkError] or the mapped [response object][T].
     *
     * @see doNetworkRequest
     */
    protected fun <T : DataMapper<S>, S> doNetworkRequestWithMapping(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, S>> = doNetworkRequest(request) { responseBody ->
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
    protected fun <T> doNetworkRequestWithoutMapping(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, T>> = doNetworkRequest(request) { responseBody ->
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
    protected fun <T : DataMapper<S>, S> doNetworkRequestForList(
        request: suspend () -> Response<List<T>>
    ): Flow<Either<NetworkError, List<S>>> = doNetworkRequest(request) { responseBody ->
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
    protected fun <T> doNetworkRequestUnit(
        request: suspend () -> Response<T>
    ): Flow<Either<NetworkError, Unit>> = doNetworkRequest(request) {
        Unit
    }

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
        request().let {
            when {
                it.isSuccessful -> {
                    it.body()?.let { responseBody ->
                        emit(Either.Right(successful.invoke(responseBody)))
                    }
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
    ): Flow<List<S>> = request().mapList { data -> data.toDomain() }
}