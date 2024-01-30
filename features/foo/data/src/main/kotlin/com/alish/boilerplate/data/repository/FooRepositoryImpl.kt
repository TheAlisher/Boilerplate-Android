package com.alish.boilerplate.data.repository

import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.db.daos.FooDao
import com.alish.boilerplate.data.db.entities.toEntity
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.pagingsources.FooPagingSource
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.repositories.FooRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService,
    private val dao: FooDao,
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchFoo().onSuccess { data ->
            //dao.insertFoo(data.toEntity())
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

    override fun getFoo() = flow<List<Foo>> {
        listOf(Foo(1, ""))
    }
}