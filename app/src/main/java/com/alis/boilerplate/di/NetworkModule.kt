package com.alis.boilerplate.di

import com.alis.boilerplate.data.network.ktor.KtorClient
import com.alis.boilerplate.data.network.ktor.KtorRequests
import com.alis.boilerplate.data.network.retrofit.API
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
    fun provideAPI(): API {
        return RetrofitClient().provideAPI()
    }

    @Singleton
    @Provides
    fun provideKtorRequests() = KtorRequests(KtorClient().provideKtor())
}