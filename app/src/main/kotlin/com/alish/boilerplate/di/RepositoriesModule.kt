package com.alish.boilerplate.di

import com.alish.boilerplate.foo.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.foo.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindFooRepository(
        repositoryImpl: FooRepositoryImpl
    ): FooRepository
}