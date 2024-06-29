package com.alish.boilerplate.foo.di

import com.alish.boilerplate.data.remote.NetworkClient
import com.alish.boilerplate.foo.data.network.apiservice.FooApiService
import com.alish.boilerplate.foo.data.repository.FooRepositoryImpl
import com.alish.boilerplate.foo.domain.repository.FooRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FooModule {

    @Singleton
    @Provides
    fun provideFooApiService(
        client: NetworkClient
    ): FooApiService = client.provideApiService()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class FooRepoModule {

    @Binds
    abstract fun bindFooRepository(
        repositoryImpl: FooRepositoryImpl
    ): FooRepository
}