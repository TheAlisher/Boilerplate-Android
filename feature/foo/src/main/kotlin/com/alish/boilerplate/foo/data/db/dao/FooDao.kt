package com.alish.boilerplate.foo.data.db.dao

import androidx.room.*
import com.alish.boilerplate.foo.data.db.model.FooDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface FooDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoo(foo: FooDBO)

    // TODO: make suspend
    @Query("SELECT * FROM foo WHERE id = :id")
    fun getFooById(id: Long): Flow<FooDBO>

    // TODO: make suspend
    @Query("SELECT * FROM foo")
    fun getAllFoo(): Flow<List<FooDBO>>
}