package com.alish.boilerplate.bar.di

import com.alish.boilerplate.bar.data.network.apiservice.BarApiService
import com.alish.boilerplate.data.remote.NetworkClient
import com.alish.boilerplate.bar.data.repository.BarRepositoryImpl
import com.alish.boilerplate.bar.domain.repository.BarRepository
import dagger.Binds
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

@Module
@InstallIn(SingletonComponent::class)
abstract class BarRepoModule {

    @Binds
    abstract fun bindBarRepository(
        repositoryImpl: BarRepositoryImpl
    ): BarRepository
}