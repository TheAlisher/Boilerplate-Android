package com.alish.boilerplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alish.boilerplate.bar.data.db.dao.BarDao
import com.alish.boilerplate.bar.data.db.model.BarDBO
import com.alish.boilerplate.foo.data.db.dao.FooDao
import com.alish.boilerplate.foo.data.db.model.FooDBO

/**
 * Must to read
 *
 * [Google issue](https://issuetracker.google.com/issues/67967869)
 *
 * [GitHub issue](https://github.com/android/architecture-components-samples/issues/274)
 */
@Database(
    entities = [
        FooDBO::class,
        BarDBO::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao

    abstract fun barDao(): BarDao
}