package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.common.base.BaseRepository
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.toFoo
import com.alish.boilerplate.data.remote.pagingsources.FooPagingSource
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