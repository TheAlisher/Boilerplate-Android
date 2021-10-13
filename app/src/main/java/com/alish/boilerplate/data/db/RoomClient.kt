package com.alish.boilerplate.data.db

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.data.db.daos.FooDao

class RoomClient {

    fun provideRoom(context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, "boilerplate.db")
        .build()

    fun provideFooDao(appDatabase: AppDatabase): FooDao = appDatabase
        .fooDao()
}