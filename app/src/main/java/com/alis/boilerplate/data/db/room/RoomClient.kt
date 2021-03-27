package com.alis.boilerplate.data.db.room

import android.content.Context
import androidx.room.Room
import com.alis.boilerplate.data.local.RoomFooDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, RoomDatabase::class.java, "boilerplate.db")
        .build()

    fun provideRoomFooDao(roomDatabase: RoomDatabase): RoomFooDao = roomDatabase
        .roomFooDao()
}