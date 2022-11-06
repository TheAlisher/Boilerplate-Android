package com.alish.boilerplate.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alish.boilerplate.data.local.db.daos.FooDao
import com.alish.boilerplate.data.local.db.entities.foo.FooEntity

@Database(entities = [FooEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}