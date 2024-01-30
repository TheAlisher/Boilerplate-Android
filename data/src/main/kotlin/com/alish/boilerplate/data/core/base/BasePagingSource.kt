package com.alish.boilerplate.data.core.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alish.boilerplate.data.remote.dtos.foo.FooPagingResponse
import com.alish.boilerplate.data.core.utils.DataMapper
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.io.InterruptedIOException

private const val BASE_STARTING_PAGE_INDEX = 1

/**
 * Base class for create [PagingSource]
 *
 * @author Alish
 *
 * @see DataMapper
 */
abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> Response<FooPagingResponse<ValueDto>>,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX

        return try {
            val response = request(position)
            val body = response.body()!!

            LoadResult.Page(
                data = body.data.map { it.mapToDomain() },
                prevKey = null,
                nextKey = body.next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: NullPointerException) {
            LoadResult.Error(exception)
        } catch (exception: InterruptedIOException) {
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