package com.alish.boilerplate.foo.data.db.daos

import androidx.room.*
import com.alish.boilerplate.foo.data.db.models.FooDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface FooDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoo(foo: FooDBO)

    @Query("SELECT * FROM foo WHERE id = :id")
    fun getFooById(id: Long): Flow<FooDBO>

    @Query("SELECT * FROM foo")
    fun getAllFoo(): Flow<List<FooDBO>>
}