package com.alis.boilerplate.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alis.boilerplate.data.network.BoilerplateService
import com.alis.boilerplate.models.Boilerplate
import okio.IOException
import retrofit2.HttpException

private const val BOILERPLATE_STARTING_PAGE_INDEX = 1

class BoilerplatePagingSource(
    private val service: BoilerplateService
) : PagingSource<Int, Boilerplate>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Boilerplate> {
        val startingPageNumber = params.key ?: BOILERPLATE_STARTING_PAGE_INDEX

        return try {
            val response = service.fetchBoilerplate(startingPageNumber)
            val data = response.body()!!

            LoadResult.Page(
                data = data.data,
                prevKey = null,
                nextKey = data.next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Boilerplate>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}