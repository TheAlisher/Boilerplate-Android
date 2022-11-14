package com.alish.boilerplate.domain.repositories

import androidx.paging.PagingData
import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.domain.utils.RemotePagingWrapper
import com.alish.boilerplate.domain.utils.RemoteWrapper
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): RemoteWrapper<Foo>

    fun fetchFooPaging(): RemotePagingWrapper<Foo>
}