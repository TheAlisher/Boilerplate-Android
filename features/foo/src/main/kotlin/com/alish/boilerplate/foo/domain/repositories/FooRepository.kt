package com.alish.boilerplate.foo.domain.repositories

import com.alish.boilerplate.foo.domain.models.Foo
import com.alish.boilerplate.domain.core.RemotePagingWrapper
import com.alish.boilerplate.domain.core.RemoteWrapper
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): RemoteWrapper<Foo>

    fun fetchPrimitives(): RemoteWrapper<String>

    fun fetchFooList(): RemoteWrapper<List<Foo>>

    fun fetchFooUnit(): RemoteWrapper<Unit>

    fun fetchFooPaging(): RemotePagingWrapper<Foo>

    fun getFoo(): Flow<List<Foo>>
}