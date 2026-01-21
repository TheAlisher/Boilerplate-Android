package com.alish.boilerplate.bar.di

import com.alish.boilerplate.bar.data.repository.BarRepositoryImpl
import com.alish.boilerplate.bar.domain.repository.BarRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BarBinderModule {

    @Binds
    abstract fun bindBarRepository(
        repository: BarRepositoryImpl
    ): BarRepository
}