package com.alish.boilerplate.data.remote.pagingsources

import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import com.alish.boilerplate.data.remote.dtos.foo.toDomain
import com.alish.boilerplate.data.remote.pagingsources.base.BasePagingSource
import com.alish.boilerplate.domain.models.Foo

class FooPagingSource(
    private val service: FooApiService
) : BasePagingSource<FooDto, Foo>(
    { service.fetchFooPaging(it) },
    { data -> data.map { it.toDomain() } }
)