package com.alish.boilerplate.data.remote.client.authenticator

import com.alish.boilerplate.data.local.preferences.UserDataPreferences
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.dtos.tokens.RefreshToken
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val userData: UserDataPreferences,
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val tokens = service.refreshToken(RefreshToken("<refresh_token>")).execute()

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
}