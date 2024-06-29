package com.alish.boilerplate.foo.domain.repository

import com.alish.boilerplate.foo.domain.model.Foo
import com.alish.boilerplate.domain.core.RemotePagingWrapper
import com.alish.boilerplate.domain.core.RemoteWrapper
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): RemoteWrapper<Foo>

    fun fetchPrimitives(): RemoteWrapper<String>

    fun fetchFooList(): RemoteWrapper<List<Foo>>

    fun fetchFooUnit(): RemoteWrapper<Unit>

    fun fetchFooPaging(): RemotePagingWrapper<Foo>

    fun getFooById(id: Long): Flow<Foo>

    fun getFooList(): Flow<List<Foo>>
}