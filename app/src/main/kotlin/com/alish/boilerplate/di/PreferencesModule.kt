package com.alish.boilerplate.di

import android.content.Context
import com.alish.boilerplate.data.local.preferences.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun providePreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)
}