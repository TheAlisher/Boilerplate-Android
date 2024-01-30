package com.alish.boilerplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alish.boilerplate.data.db.daos.FooDao
import com.alish.boilerplate.data.db.entities.FooEntity

@Database(entities = [FooEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}