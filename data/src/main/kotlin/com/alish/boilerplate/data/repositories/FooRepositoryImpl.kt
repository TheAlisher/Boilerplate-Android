package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.pagingsources.FooPagingSource
import com.alish.boilerplate.data.repositories.base.BaseRepository
import com.alish.boilerplate.domain.repositories.FooRepository
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequest {
        service.fetchFoo().also { data ->
            data.body()?.let {
                /**
                 * Do something with [data]
                 * */
                it.bar
            }
        }
    }

    override fun fetchFooPaging() = doPagingRequest(FooPagingSource(service))
}