package com.alish.boilerplate.di

import android.content.Context
import androidx.room.Room
import com.alish.boilerplate.data.db.daos.FooDao
import com.alish.boilerplate.db.AppDatabase
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
        @ApplicationContext context: Context,
    ): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "boilerplate.db")
        .build()

    @Singleton
    @Provides
    fun provideFooDao(
        db: AppDatabase,
    ): FooDao = db.fooDao()
}