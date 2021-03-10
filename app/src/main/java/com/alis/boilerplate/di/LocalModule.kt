package com.alis.boilerplate.di

import android.content.Context
import com.alis.boilerplate.data.db.room.RoomClient
import com.alis.boilerplate.data.db.room.RoomDatabase
import com.alis.boilerplate.data.local.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): RoomDatabase {
        return RoomClient().provideRoom(context)
    }

    @Singleton
    @Provides
    fun provideRoomDao(roomDatabase: RoomDatabase): RoomDao {
        return RoomClient().provideRoomDao(roomDatabase)
    }
}