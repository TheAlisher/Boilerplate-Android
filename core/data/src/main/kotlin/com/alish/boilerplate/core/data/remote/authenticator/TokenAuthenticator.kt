package com.alish.boilerplate.core.data.remote.authenticator

import com.alish.boilerplate.core.data.local.preferences.UserDataPreferences
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
	private val service: AuthenticatorApiService,
	private val userData: UserDataPreferences,
) : Authenticator {

    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        val currentToken = userData.accessToken
        if (response.request.header("Authorization") != "Bearer $currentToken") {
            return response.request.newBuilder()
                .header("Authorization", "Bearer $currentToken")
                .build()
        }

        val tokens = service.refreshToken(
            RefreshToken(userData.refreshToken)
        ).execute()

        return when {
            tokens.isSuccessful && tokens.body() != null -> {
                with(userData) {
                    accessToken = tokens.body()!!.accessToken
                    refreshToken = tokens.body()!!.refreshToken
                }

                response
                    .request
                    .newBuilder()
                    .header("Authorization", "Bearer ${userData.accessToken}")
                    .build()
            }

            else -> {
                null
            }
        }
    }
}