package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.base.BaseRepository
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.domain.repositories.RequestRepository

class RequestRepositoryImpl(
    private val service: FooApiService
) : BaseRepository(), RequestRepository {

    override fun fetchFoo() = doRequest {
        service.fetchFoo()
    }
}