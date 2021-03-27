package com.alis.boilerplate.data.db.room

import android.content.Context
import androidx.room.Room
import com.alis.boilerplate.data.local.BoilerplateDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, RoomDatabase::class.java, "boilerplate.db")
        .build()

    fun provideBoilerplateDao(roomDatabase: RoomDatabase): BoilerplateDao =
        roomDatabase.boilerplateDao()
}