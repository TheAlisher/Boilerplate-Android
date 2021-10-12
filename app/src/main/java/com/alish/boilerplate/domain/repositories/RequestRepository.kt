package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.data.resource.Resource
import com.alish.boilerplate.models.Foo
import kotlinx.coroutines.flow.Flow

interface RequestRepository {

    fun fetchFoo(): Flow<Resource<Foo>>
}