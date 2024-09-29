package com.alish.boilerplate.foo.data.repository

import com.alish.boilerplate.foo.data.pagingsource.FooPagingSource
import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.core.utils.onSuccess
import com.alish.boilerplate.foo.data.db.dao.FooDao
import com.alish.boilerplate.foo.data.network.apiservice.FooApiService
import com.alish.boilerplate.foo.domain.repository.FooRepository
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService,
    private val dao: FooDao,
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchFoo().onSuccess { data ->
            dao.insertFoo(data.asDBO())
        }
    }

    override fun fetchPrimitives() = doNetworkRequestWithoutMapping {
        service.fetchPrimitives()
    }

    override fun fetchFooList() = doNetworkRequestForList {
        service.fetchFooList()
    }

    override fun fetchFooUnit() = doNetworkRequestUnit {
        service.fetchFoo()
    }

    override fun fetchFooPaging() = doPagingRequest({
        FooPagingSource(service)
    })

    override fun getFooById(id: Long) = doLocalRequest {
        dao.getFooById(id)
    }

    override fun getFooList() = doLocalRequestForList {
        dao.getAllFoo()
    }
}