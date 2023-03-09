package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.pagingsources.FooPagingSource
import com.alish.boilerplate.data.base.BaseRepository
import com.alish.boilerplate.data.local.db.daos.FooDao
import com.alish.boilerplate.data.local.db.entities.foo.toEntity
import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.domain.repositories.FooRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService,
    private val dao: FooDao
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchFoo().onSuccess { data ->
            dao.insertFoo(data.toEntity())
        }
    }

    override fun fetchFooPaging() = doPagingRequest({ FooPagingSource(service) })

    override fun getFoo() = doLocalRequest {
        dao.getAllFoo()
    }
}