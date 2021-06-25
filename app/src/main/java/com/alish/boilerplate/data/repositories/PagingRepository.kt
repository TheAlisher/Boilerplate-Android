package com.alish.boilerplate.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.data.network.retrofit.apiservices.FooPagingApiService
import com.alish.boilerplate.data.repositories.pagingsources.FooPagingSource
import com.alish.boilerplate.models.paging.FooPagingData
import kotlinx.coroutines.flow.Flow

class PagingRepository(
    private val service: FooPagingApiService
) {

    fun fetchFooPaging(): Flow<PagingData<FooPagingData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            )
        ) {
            FooPagingSource(service)
        }.flow
    }
}