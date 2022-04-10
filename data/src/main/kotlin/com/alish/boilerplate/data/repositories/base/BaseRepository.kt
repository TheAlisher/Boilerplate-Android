package com.alish.boilerplate.data.repositories.base

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.remote.pagingsources.base.BasePagingSource
import com.alish.boilerplate.domain.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(
        doSomethingInSuccess: ((T) -> Unit)? = null,
        request: suspend () -> T
    ) = flow<Either<String, T>> {
        request().also { data ->
            doSomethingInSuccess?.invoke(data)
            emit(Either.Right(value = data))
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        if (BuildConfig.DEBUG) {
            Log.e("RepositoryError", this@BaseRepository.javaClass.name, exception)
        }
        emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
    }

    protected fun <ValueDto : Any, Value : Any> doPagingRequest(
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