package com.alis.boilerplate.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alis.boilerplate.data.db.room.daos.RoomFooDao
import com.alis.boilerplate.models.room.FooRoomEntity

@Database(entities = [FooRoomEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RoomAppDatabase : RoomDatabase() {

    abstract fun roomFooDao(): RoomFooDao
}