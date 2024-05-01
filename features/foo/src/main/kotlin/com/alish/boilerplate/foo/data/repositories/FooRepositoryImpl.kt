package com.alish.boilerplate.foo.data.repositories

import com.alish.boilerplate.foo.data.pagingsources.FooPagingSource
import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.core.utils.onSuccess
import com.alish.boilerplate.foo.data.db.daos.FooDao
import com.alish.boilerplate.foo.data.network.apiservices.FooApiService
import com.alish.boilerplate.foo.domain.models.Foo
import com.alish.boilerplate.foo.domain.repositories.FooRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService,
    private val dao: FooDao,
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchFoo().onSuccess { data ->
            dao.insertFoo(data.toDBO())
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