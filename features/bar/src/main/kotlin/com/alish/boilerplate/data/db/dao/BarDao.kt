package com.alish.boilerplate.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.alish.boilerplate.data.db.model.BarDBO

@Dao
interface BarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBar(bar: BarDBO)
}