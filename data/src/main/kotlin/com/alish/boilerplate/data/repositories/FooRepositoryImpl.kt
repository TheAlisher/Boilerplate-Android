package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.repositories.base.BaseRepository
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.foo.toDomain
import com.alish.boilerplate.data.remote.pagingsources.FooPagingSource
import com.alish.boilerplate.domain.repositories.FooRepository
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doRequest {
        service.fetchFoo().toDomain()
    }

    fun fetchFooPaging() = doPagingRequest(FooPagingSource(service))
}