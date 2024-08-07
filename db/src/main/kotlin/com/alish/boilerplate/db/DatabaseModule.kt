package com.alish.boilerplate.db

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.bar.data.db.dao.BarDao
import com.alish.boilerplate.data.local.db.DatabaseConstants
import com.alish.boilerplate.foo.data.db.dao.FooDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        context: Context
    ): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DatabaseConstants.NAME)
        .build()

    @Singleton
    @Provides
    fun provideFooDao(
        db: AppDatabase
    ): FooDao = db.fooDao()

    @Singleton
    @Provides
    fun provideBarDao(
        db: AppDatabase
    ): BarDao = db.barDao()
}