package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.Resource
import com.alish.boilerplate.domain.models.Foo
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): Flow<Resource<Foo>>
}