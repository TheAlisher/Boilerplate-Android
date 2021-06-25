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
    val roomClient = RoomClient()

    @Provides
    fun provideRoom(
        @ApplicationContext context: Context
    ): RoomAppDatabase = roomClient.provideRoom(context)

    @Provides
    fun provideRoomFooDao(
        appDatabase: RoomAppDatabase
    ): RoomFooDao = roomClient.provideRoomFooDao(appDatabase)
}