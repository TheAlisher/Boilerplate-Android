package com.alish.boilerplate.data.pagingsources

import com.alish.boilerplate.data.core.base.BasePagingSource
import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.network.dtos.FooDto
import com.alish.boilerplate.domain.models.Foo

class FooPagingSource(
    private val service: FooApiService,
) : BasePagingSource<FooDto, Foo>({
    service.fetchFooPaging(it)
})