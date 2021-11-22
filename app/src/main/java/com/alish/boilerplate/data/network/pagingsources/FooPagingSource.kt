package com.alish.boilerplate.data.network.pagingsources

import com.alish.boilerplate.common.base.BasePagingSource
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.network.dtos.FooDto
import com.alish.boilerplate.data.network.dtos.toFoo
import com.alish.boilerplate.domain.models.Foo

class FooPagingSource(
    private val service: FooApiService
) : BasePagingSource<FooDto, Foo>(
    { service.fetchFooPaging(it) }, { data -> data.map { it.toFoo() } }
)