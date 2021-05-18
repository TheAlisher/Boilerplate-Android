package com.alish.boilerplate.di

import android.content.Context
import com.alish.boilerplate.data.db.room.RoomAppDatabase
import com.alish.boilerplate.data.db.room.RoomClient
import com.alish.boilerplate.data.db.room.daos.RoomFooDao
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
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context
    ): RoomAppDatabase = RoomClient().provideRoom(context)

    @Singleton
    @Provides
    fun provideRoomFooDao(
        appDatabase: RoomAppDatabase
    ): RoomFooDao = RoomClient().provideRoomFooDao(appDatabase)
}