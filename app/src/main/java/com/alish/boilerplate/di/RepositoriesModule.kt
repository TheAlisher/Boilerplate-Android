package com.alish.boilerplate.di

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
    fun provideFooRepository(
        fooRepositoryImpl: FooRepositoryImpl
    ): FooRepository {
        return fooRepositoryImpl
    }
}