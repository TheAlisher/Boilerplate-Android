package com.alish.boilerplate.di

import com.alish.boilerplate.data.network.ProviderFooApiService
import com.alish.boilerplate.data.network.ProviderBarApiService
import com.alish.boilerplate.data.network.ProviderBazApiService
import com.alish.boilerplate.data.remote.client.NetworkClient
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
        authenticatorClient: NetworkClient.AuthenticatorClient,
    ) = authenticatorClient.provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideFooApiService(
        providerFooApiService: ProviderFooApiService,
    ) = providerFooApiService()

    @Singleton
    @Provides
    fun provideBarApiService(
        providerBarApiService: ProviderBarApiService,
    ) = providerBarApiService()

    @Singleton
    @Provides
    fun provideBazApiService(
        providerBazApiService: ProviderBazApiService,
    ) = providerBazApiService()
}