package com.alish.boilerplate.data.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alish.boilerplate.data.remote.dtos.foo.FooPagingResponse
import com.alish.boilerplate.data.utils.DataMapper
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val BASE_STARTING_PAGE_INDEX = 1

abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> Response<FooPagingResponse<ValueDto>>,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX

        return try {
            val response = request(position)
            val data = response.body()!!

            LoadResult.Page(
                data = data.data.map { it.mapToDomain() },
                prevKey = null,
                nextKey = data.next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}