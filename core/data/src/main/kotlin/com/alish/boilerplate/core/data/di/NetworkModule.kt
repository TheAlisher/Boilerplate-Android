package com.alish.boilerplate.core.data.di

import com.alish.boilerplate.core.data.remote.NetworkClient
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
}