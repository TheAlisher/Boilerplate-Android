package com.alish.boilerplate.foo.data.pagingsources

import com.alish.boilerplate.data.core.base.BasePagingSource
import com.alish.boilerplate.foo.data.network.apiservices.FooApiService
import com.alish.boilerplate.foo.data.network.models.FooDto
import com.alish.boilerplate.foo.domain.models.Foo

class FooPagingSource(
    private val service: FooApiService,
) : BasePagingSource<FooDto, Foo>({
    service.fetchFooPaging(it)
})