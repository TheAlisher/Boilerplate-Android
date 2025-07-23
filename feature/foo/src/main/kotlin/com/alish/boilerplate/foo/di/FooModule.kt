package com.alish.boilerplate.foo.di

import com.alish.boilerplate.core.data.remote.NetworkClient
import com.alish.boilerplate.foo.data.network.apiservice.FooApiService
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