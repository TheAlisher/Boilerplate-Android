package com.alish.boilerplate.foo.data.pagingsource

import com.alish.boilerplate.data.core.base.BasePagingSource
import com.alish.boilerplate.foo.data.network.apiservice.FooApiService
import com.alish.boilerplate.foo.data.network.model.FooDTO
import com.alish.boilerplate.foo.domain.model.Foo

class FooPagingSource(
    private val service: FooApiService,
) : BasePagingSource<FooDTO, Foo>({
    service.fetchFooPaging(it)
})