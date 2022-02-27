package com.alish.boilerplate.di

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.remote.RetrofitClient
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
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Singleton
    @Provides
    fun provideAuthenticatorApiService() = RetrofitClient.Authenticator()
        .provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideFooApiService(
        retrofitClient: RetrofitClient
    ) = retrofitClient.provideFooApiService()
}