package com.alis.boilerplate.data.db.room

import android.content.Context
import androidx.room.Room
import com.alis.boilerplate.data.db.room.daos.RoomFooDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, RoomDatabase::class.java, "database-boilerplate")
        .build()

    fun provideRoomFooDao(roomDatabase: RoomDatabase): RoomFooDao = roomDatabase
        .roomFooDao()
}