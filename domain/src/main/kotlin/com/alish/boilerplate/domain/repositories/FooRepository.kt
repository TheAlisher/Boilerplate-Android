package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.domain.core.RemotePagingWrapper
import com.alish.boilerplate.domain.core.RemoteWrapper
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): RemoteWrapper<Foo>

    fun fetchFooPaging(): RemotePagingWrapper<Foo>

    fun getFoo(): Flow<List<Foo>>
}