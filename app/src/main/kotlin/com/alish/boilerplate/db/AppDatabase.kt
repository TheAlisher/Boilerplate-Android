package com.alish.boilerplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alish.boilerplate.foo.data.db.daos.FooDao
import com.alish.boilerplate.foo.data.db.entities.FooEntity

/**
 * [Must to read](https://issuetracker.google.com/issues/67967869)
 */
@Database(entities = [FooEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}