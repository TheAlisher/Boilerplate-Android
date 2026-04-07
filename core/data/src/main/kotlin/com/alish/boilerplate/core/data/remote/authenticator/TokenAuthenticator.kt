package com.alish.boilerplate.core.data.remote.authenticator

import com.alish.boilerplate.core.data.local.preferences.UserDataPreferences
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val userData: UserDataPreferences,
) : Authenticator {

    companion object {
        private val mutex = Mutex()
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val requestAccessToken = response.request
            .header("Authorization")
            ?.removePrefix("Bearer ")

        return runBlocking {
            mutex.withLock {
                val currentAccessToken = userData.accessToken

                if (currentAccessToken != requestAccessToken) {
                    response.request
                        .newBuilder()
                        .header("Authorization", "Bearer $currentAccessToken")
                        .build()
                } else {
                    refreshToken(response)
                }
            }
        }
    }

    private suspend fun refreshToken(response: Response): Request? {
        return try {
            val tokens = service.refreshToken(RefreshToken(userData.refreshToken))

            userData.accessToken = tokens.accessToken
            userData.refreshToken = tokens.refreshToken

            response.request
                .newBuilder()
                .header("Authorization", "Bearer ${tokens.accessToken}")
                .build()
        } catch (e: Exception) {
            null
        }
    }
}