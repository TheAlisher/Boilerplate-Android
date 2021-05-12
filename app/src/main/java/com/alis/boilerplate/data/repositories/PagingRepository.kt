package com.alis.boilerplate.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.alis.boilerplate.data.network.retrofit.apiservices.FooPagingApiService
import com.alis.boilerplate.data.repositories.pagingsources.FooPagingSource
import com.alis.boilerplate.models.paging.FooPagingData

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