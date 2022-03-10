package com.alish.boilerplate.di

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.remote.NetworkClient
import com.alish.boilerplate.data.remote.OkHttp
import com.alish.boilerplate.data.remote.RetrofitClient
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Singleton
    @Provides
    fun provideAuthenticatorApiService(
        authenticatorClient: NetworkClient.AuthenticatorClient
    ) = authenticatorClient.provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideFooApiService(
        networkClient: NetworkClient
    ) = networkClient.provideFooApiService()
}