package com.alis.boilerplate.data.db.room

import android.content.Context
import androidx.room.Room
import com.alis.boilerplate.data.local.Dao

class RoomClient(context: Context) {

    private val roomDatabase: RoomDatabase = Room
        .databaseBuilder(context, RoomDatabase::class.java, "boilerplate.db")
        .build()

    fun provideDao(): Dao = roomDatabase.dao()
}