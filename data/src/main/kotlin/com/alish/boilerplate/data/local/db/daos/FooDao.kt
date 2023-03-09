package com.alish.boilerplate.data.local.db.daos

import androidx.room.*
import com.alish.boilerplate.data.local.db.entities.foo.FooEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FooDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoo(foo: FooEntity)

    @Query("SELECT * FROM foo")
    fun getAllFoo(): Flow<List<FooEntity>>
}