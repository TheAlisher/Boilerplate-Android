package com.alish.boilerplate.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alish.boilerplate.data.db.daos.FooDao
import com.alish.boilerplate.data.db.models.FooDB

@Database(entities = [FooDB::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}