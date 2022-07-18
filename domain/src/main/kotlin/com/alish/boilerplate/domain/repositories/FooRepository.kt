package com.alish.boilerplate.domain.repositories

import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow

interface FooRepository {

    fun fetchFoo(): Flow<Either<NetworkError, Foo>>
}