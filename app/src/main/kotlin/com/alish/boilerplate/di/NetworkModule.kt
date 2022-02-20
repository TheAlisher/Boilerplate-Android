package com.alish.boilerplate.di

import com.alish.boilerplate.data.remote.RetrofitClient
import com.alish.boilerplate.data.remote.authenticator.AuthenticatorClient
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
    fun provideAuthenticatorApiService() = AuthenticatorClient().provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideFooApiService(retrofitClient: RetrofitClient) = retrofitClient.provideFooApiService()
}