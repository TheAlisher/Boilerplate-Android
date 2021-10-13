package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.data.resource.Resource
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.models.FooPagingResponse
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): Flow<Resource<Foo>>
}