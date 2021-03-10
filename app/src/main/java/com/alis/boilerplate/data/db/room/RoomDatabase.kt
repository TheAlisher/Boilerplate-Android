package com.alis.boilerplate.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alis.boilerplate.data.local.RoomDao
import com.alis.boilerplate.models.room.RoomEntity

@Database(entities = [RoomEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RoomDatabase : RoomDatabase() {

    abstract fun roomDao(): RoomDao
}