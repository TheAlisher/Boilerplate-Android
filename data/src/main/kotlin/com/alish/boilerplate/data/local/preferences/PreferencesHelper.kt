package com.alish.boilerplate.data.local.preferences

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper @Inject constructor(
	context: Context,
) {

	private val masterKey: MasterKey = MasterKey.Builder(context)
		.setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
		.build()

	private val preferences = EncryptedSharedPreferences.create(
		context,
		PreferencesConstants.NAME,
		masterKey,
		EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
		EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
	)

	private val editor = preferences.edit()

	private fun remove(key: String) {
		preferences.edit().remove(key).apply()
	}
}