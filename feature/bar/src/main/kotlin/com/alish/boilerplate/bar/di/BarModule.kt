package com.alish.boilerplate.bar.di

import com.alish.boilerplate.bar.data.network.apiservice.BarApiService
import com.alish.boilerplate.core.data.remote.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BarModule {

    @Provides
    @Singleton
    fun provideBarApiService(
        client: NetworkClient
    ): BarApiService = client.provideApiService()
}