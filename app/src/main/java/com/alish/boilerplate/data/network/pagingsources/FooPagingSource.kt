package com.alish.boilerplate.data.network.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.network.dtos.toFoo
import com.alish.boilerplate.domain.models.Foo
import retrofit2.HttpException
import java.io.IOException

private const val FOO_STARTING_PAGE_INDEX = 1

class FooPagingSource(
    private val service: FooApiService
) : PagingSource<Int, Foo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Foo> {
        val startingPageNumber = params.key ?: FOO_STARTING_PAGE_INDEX

        return try {
            val response = service.fetchFooPaging(startingPageNumber)
            val data = response.body()!!

            LoadResult.Page(
                data = data.data.map { it.toFoo() },
                prevKey = null,
                nextKey = data.next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Foo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}