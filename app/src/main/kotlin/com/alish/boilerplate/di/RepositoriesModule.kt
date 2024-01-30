package com.alish.boilerplate.di

import com.alish.boilerplate.data.repository.BarRepositoryImpl
import com.alish.boilerplate.data.repository.BazRepositoryImpl
import com.alish.boilerplate.data.repository.FooRepositoryImpl
import com.alish.boilerplate.domain.repositories.BarRepository
import com.alish.boilerplate.domain.repositories.BazRepository
import com.alish.boilerplate.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindFooRepository(
        repositoryImpl: FooRepositoryImpl,
    ): FooRepository

    @Binds
    abstract fun bindBarRepository(
        repositoryImpl: BarRepositoryImpl,
    ): BarRepository

    @Binds
    abstract fun bindBazRepository(
        repositoryImpl: BazRepositoryImpl,
    ): BazRepository
}