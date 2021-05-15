package com.alis.boilerplate.data.db.room

import android.content.Context
import androidx.room.Room
import com.alis.boilerplate.data.db.room.daos.RoomFooDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, RoomAppDatabase::class.java, "boilerplate.db")
        .build()

    fun provideRoomFooDao(appDatabase: RoomAppDatabase): RoomFooDao = appDatabase
        .roomFooDao()
}