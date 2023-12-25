package com.alish.boilerplate.data.local.db

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.data.local.db.daos.FooDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseClient @Inject constructor(
    context: Context
) {

    private val provideAppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "boilerplate.db")
        .build()

    fun provideFooDao(): FooDao = provideAppDatabase.fooDao()
}