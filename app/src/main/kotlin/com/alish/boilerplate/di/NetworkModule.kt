package com.alish.boilerplate.di

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.remote.NetworkClient
import com.alish.boilerplate.foo.data.network.apiservices.FooApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAuthenticatorApiService(
        client: NetworkClient.AuthenticatorClient
    ) = client.provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideFooApiService(
        client: NetworkClient
    ): FooApiService = client.provideApiService()
}