package com.alis.boilerplate.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.alis.boilerplate.data.paging.FooPagingService
import com.alis.boilerplate.data.paging.FooPagingSource
import com.alis.boilerplate.models.paging.FooPagingData

class PagingRepository(
    private val service: FooPagingService
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