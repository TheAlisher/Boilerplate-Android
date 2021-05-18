package com.alish.boilerplate.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.alish.boilerplate.data.network.retrofit.apiservices.FooPagingApiService
import com.alish.boilerplate.data.repositories.pagingsources.FooPagingSource
import com.alish.boilerplate.models.paging.FooPagingData

class PagingRepository(
    private val service: FooPagingApiService
) {

    fun fetchFooPagingData(): LiveData<PagingData<FooPagingData>> {
        return Pager(
            config = PagingConfig(
                pageSize = BOILERPLATE_PAGE_SIZE
            )
        ) {
            FooPagingSource(service)
        }.liveData
    }

    companion object {
        private const val BOILERPLATE_PAGE_SIZE = 10
    }
}