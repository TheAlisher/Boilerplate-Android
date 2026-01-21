package com.alish.boilerplate.db

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.bar.data.db.dao.BarDao
import com.alish.boilerplate.db.DatabaseConstants
import com.alish.boilerplate.foo.data.db.dao.FooDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DatabaseConstants.NAME)
        .build()

    @Singleton
    @Provides
    fun provideFooDao(
        database: AppDatabase
    ): FooDao = database.fooDao()

    @Singleton
    @Provides
    fun provideBarDao(
        database: AppDatabase
    ): BarDao = database.barDao()
}