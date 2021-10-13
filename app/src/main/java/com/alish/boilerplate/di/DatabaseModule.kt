package com.alish.boilerplate.di

import android.content.Context
import com.alish.boilerplate.data.db.AppDatabase
import com.alish.boilerplate.data.db.RoomClient
import com.alish.boilerplate.data.db.daos.FooDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    val roomClient = RoomClient()

    @Singleton
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context
    ): AppDatabase = roomClient.provideRoom(context)

    @Singleton
    @Provides
    fun provideFooDao(
        appDatabase: AppDatabase
    ): FooDao = roomClient.provideFooDao(appDatabase)
}