package com.alish.boilerplate.di

import com.alish.boilerplate.data.remote.authenticator.AuthenticatorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticatorModule {

    @Singleton
    @Provides
    fun provideAuthenticatorApiService() = AuthenticatorClient().provideAuthenticatorApiService()
}