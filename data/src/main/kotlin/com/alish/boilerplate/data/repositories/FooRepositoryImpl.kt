package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.foo.toDomain
import com.alish.boilerplate.data.remote.pagingsources.FooPagingSource
import com.alish.boilerplate.data.repositories.core.doPagingRequest
import com.alish.boilerplate.data.repositories.core.doRequest
import com.alish.boilerplate.domain.repositories.FooRepository
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService
) : FooRepository {

    override fun fetchFoo() = doRequest {
        service.fetchFoo().also {
            it.bar
        }.toDomain()
    }.catch { exception ->
        exception.message
    }

    fun fetchFooPaging() = doPagingRequest(FooPagingSource(service))
}