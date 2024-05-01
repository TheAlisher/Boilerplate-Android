package com.alish.boilerplate.di

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.data.db.dao.BarDao
import com.alish.boilerplate.db.AppDatabase
import com.alish.boilerplate.foo.data.db.daos.FooDao
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
        .databaseBuilder(context, AppDatabase::class.java, "boilerplate.db")
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