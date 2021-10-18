package com.alish.boilerplate.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alish.boilerplate.base.BaseRepository
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.network.dtos.toFoo
import com.alish.boilerplate.data.repositories.pagingsources.FooPagingSource
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.repositories.FooRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doRequest {
        service.fetchFoo().toFoo()
    }

    fun fetchFooPaging(): Flow<PagingData<Foo>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            )
        ) {
            FooPagingSource(service)
        }.flow
    }
}