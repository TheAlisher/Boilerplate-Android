package com.alis.boilerplate.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alis.boilerplate.data.db.room.RoomDatabase.Companion.DATABASE_VERSION
import com.alis.boilerplate.data.local.Dao
import com.alis.boilerplate.models.ExampleData

@Database(entities = [ExampleData::class], version = DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class RoomDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun dao(): Dao
}