package com.alish.boilerplate.common.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alish.boilerplate.data.network.dtos.FooPagingResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val BASE_STARTING_PAGE_INDEX = 1

abstract class BasePagingSource<ValueDto : Any, Value : Any>(
    private val request: suspend (position: Int) -> Response<FooPagingResponse<ValueDto>>,
    private val mappedData: (data: List<ValueDto>) -> List<Value>
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX

        return try {
            val response = request(position)
            val data = response.body()!!

            LoadResult.Page(
                data = mappedData(data.data),
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