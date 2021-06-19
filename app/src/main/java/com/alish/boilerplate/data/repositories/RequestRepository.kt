package com.alish.boilerplate.data.repositories

import androidx.lifecycle.LiveData
import com.alish.boilerplate.base.BaseRepository
import com.alish.boilerplate.data.network.resource.Resource
import com.alish.boilerplate.data.network.retrofit.apiservices.FooApiService
import com.alish.boilerplate.models.Foo

class RequestRepository(
    private val service: FooApiService
) : BaseRepository() {

    fun fetchFoo(): LiveData<Resource<Foo>> {
        return doRequest { service.fetchFoo() }
    }
}