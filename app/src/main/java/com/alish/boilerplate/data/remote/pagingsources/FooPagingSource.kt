package com.alish.boilerplate.data.remote.pagingsources

import com.alish.boilerplate.common.base.BasePagingSource
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.dtos.FooDto
import com.alish.boilerplate.data.remote.dtos.toDomain
import com.alish.boilerplate.domain.models.Foo

class FooPagingSource(
    private val service: FooApiService
) : BasePagingSource<FooDto, Foo>(
    { service.fetchFooPaging(it) },
    { data -> data.map { it.toDomain() } }
)