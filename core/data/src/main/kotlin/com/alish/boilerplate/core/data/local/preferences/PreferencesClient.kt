package com.alish.boilerplate.core.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesClient @Inject constructor(
    @ApplicationContext context: Context,
) {

    val preferences: SharedPreferences = context.getSharedPreferences(
        PreferencesConstants.NAME, Context.MODE_PRIVATE
    )

    val editor: SharedPreferences.Editor = preferences.edit()
}