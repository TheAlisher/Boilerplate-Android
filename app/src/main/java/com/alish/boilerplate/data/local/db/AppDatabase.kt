package com.alish.boilerplate.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alish.boilerplate.data.local.db.daos.FooDao
import com.alish.boilerplate.data.local.db.entities.FooEntity

@Database(entities = [FooEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}