package com.alish.boilerplate.data.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.utils.NetworkError
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.Response

abstract class BaseRepository {

    /**
     * Do network request
     *
     * @return result in [flow] with [Either]
     */
    protected fun <T : DataMapper<S>, S> doNetworkRequest(
        request: suspend () -> Response<T>
    ) = flow<Either<NetworkError, S>> {
        request().let {
            if (it.isSuccessful && it.body() != null) {
                emit(Either.Right(it.body()!!.mapToDomain()))
            } else {
                emit(Either.Left(NetworkError.Api(it.errorBody().toApiError())))
            }
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(
            Either.Left(NetworkError.Unexpected(exception.localizedMessage ?: "Error Occurred!"))
        )
    }

    /**
     * Convert network error from server side
     */
    private fun ResponseBody?.toApiError(): MutableMap<String, List<String>> {
        return Gson().fromJson(
            this?.string(),
            object : TypeToken<MutableMap<String, List<String>>>() {}.type
        )
    }

    protected inline fun <T : Response<S>, S> T.data(block: (S) -> Unit): T {
        this.body()?.let(block)
        return this
    }

    /**
     * Do network paging request with default params
     */
    protected fun <ValueDto : DataMapper<Value>, Value : Any> doPagingRequest(
        pagingSource: BasePagingSource<ValueDto, Value>,
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
                pagingSource
            }
        ).flow
    }
}