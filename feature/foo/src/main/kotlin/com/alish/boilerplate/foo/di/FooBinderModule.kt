package com.alish.boilerplate.foo.di

import com.alish.boilerplate.foo.data.repository.FooRepositoryImpl
import com.alish.boilerplate.foo.domain.repository.FooRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FooBinderModule {

    @Binds
    abstract fun bindFooRepository(
        repository: FooRepositoryImpl
    ): FooRepository
}