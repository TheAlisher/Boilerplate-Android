package com.alish.boilerplate.foo.data.repository

import com.alish.boilerplate.foo.data.pagingsource.FooPagingSource
import com.alish.boilerplate.core.data.base.BaseRepository
import com.alish.boilerplate.core.data.utils.onSuccess
import com.alish.boilerplate.foo.data.db.dao.FooDao
import com.alish.boilerplate.foo.data.network.apiservice.FooApiService
import com.alish.boilerplate.foo.domain.repository.FooRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    coroutineDispatcher: CoroutineDispatcher,
    private val service: FooApiService,
    private val dao: FooDao,
) : BaseRepository(coroutineDispatcher), FooRepository {

    override fun fetchFoo() = networkFlow {
        service.fetchFoo().onSuccess { data ->
            dao.insertFoo(data.asDBO())
        }
    }

    override fun fetchPrimitives() = networkFlowRaw {
        service.fetchPrimitives()
    }

    override fun fetchFooList() = networkFlowList {
        service.fetchFooList()
    }

    override fun fetchFooUnit() = networkFlowUnit {
        service.fetchFoo()
    }

    override fun fetchFooPaging() = pagingFlow {
        FooPagingSource(service)
    }

    override fun getFooById(id: Long) = dbFlow {
        dao.getFooById(id)
    }

    override fun getFooList() = dbFlowList {
        dao.getAllFoo()
    }
}