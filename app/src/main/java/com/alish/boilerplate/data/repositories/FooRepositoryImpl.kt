package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.common.base.BaseRepository
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.network.dtos.toFoo
import com.alish.boilerplate.data.network.pagingsources.FooPagingSource
import com.alish.boilerplate.domain.repositories.FooRepository
import it.czerwinski.android.hilt.annotations.BoundTo
import javax.inject.Inject

@BoundTo(FooRepository::class)
class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doRequest {
        service.fetchFoo().toFoo()
    }

    fun fetchFooPaging() = doPagingRequest(FooPagingSource(service))
}