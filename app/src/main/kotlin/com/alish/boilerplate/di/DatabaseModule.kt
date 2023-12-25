package com.alish.boilerplate.di

import com.alish.boilerplate.data.local.db.DatabaseClient
import com.alish.boilerplate.data.local.db.daos.FooDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideFooDao(
        databaseClient: DatabaseClient
    ): FooDao = databaseClient.provideFooDao()
}