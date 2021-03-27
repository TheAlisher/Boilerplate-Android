package com.alis.boilerplate.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.alis.boilerplate.data.network.retrofit.RetrofitBoilerplateService
import com.alis.boilerplate.data.paging.BoilerplatePagingSource
import com.alis.boilerplate.models.Boilerplate

class PagingRepository(
    private val service: RetrofitBoilerplateService
) {

    fun fetchBoilerplate(): LiveData<PagingData<Boilerplate>> {
        return Pager(
            config = PagingConfig(
                pageSize = BOILERPLATE_PAGE_SIZE
            )
        ) {
            BoilerplatePagingSource(service)
        }.liveData
    }

    companion object {
        private const val BOILERPLATE_PAGE_SIZE = 10
    }
}