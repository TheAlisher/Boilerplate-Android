package com.alish.boilerplate.core.data.local.preferences

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataPreferences @Inject constructor(
    preferencesClient: PreferencesClient,
) {

    private val preferences = preferencesClient.preferences
    private val editor = preferencesClient.editor

    var isOnboarding: Boolean
        get() = preferences.getBoolean(PreferencesConstants.PREF_IS_ONBOARDING, true)
        set(value) = editor.putBoolean(PreferencesConstants.PREF_IS_ONBOARDING, value).apply()

    var isAuthorized: Boolean
        get() = preferences.getBoolean(PreferencesConstants.PREF_IS_AUTHORIZED, true)
        set(value) = editor.putBoolean(PreferencesConstants.PREF_IS_AUTHORIZED, value).apply()

    var accessToken: String
        get() = preferences.getString(PreferencesConstants.PREF_ACCESS_TOKEN, "")!!
        set(value) = editor.putString(PreferencesConstants.PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = preferences.getString(PreferencesConstants.PREF_REFRESH_TOKEN, "")!!
        set(value) = editor.putString(PreferencesConstants.PREF_REFRESH_TOKEN, value).apply()
}