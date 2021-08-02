package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.base.BaseRepository
import com.alish.boilerplate.data.network.apiservices.FooApiService

class RequestRepository(
    private val service: FooApiService
) : BaseRepository() {

    fun fetchFoo() = doRequest {
        service.fetchFoo()
    }
}