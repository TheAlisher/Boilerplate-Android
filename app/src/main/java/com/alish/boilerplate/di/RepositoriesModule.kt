package com.alish.boilerplate.di

import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.repositories.FooRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideFooRepository(service: FooApiService): FooRepository {
        return FooRepositoryImpl(service)
    }
}