package com.alish.boilerplate.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper @Inject constructor(
    context: Context
) {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        "boilerplate.preferences", Context.MODE_PRIVATE
    )

    private fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }
}