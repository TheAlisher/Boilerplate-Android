package com.alis.boilerplate.di

import com.alis.boilerplate.data.network.ktor.KtorClient
import com.alis.boilerplate.data.network.ktor.KtorFooService
import com.alis.boilerplate.data.network.retrofit.RetrofitClient
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
    fun provideRetrofitFooService() = RetrofitClient().provideFooService()

    @Singleton
    @Provides
    fun provideKtorFooService() = KtorFooService(KtorClient().provideKtor())
}