package com.alish.boilerplate.data.remote.client.interceptors

import com.alish.boilerplate.data.local.preferences.UserDataPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val userData: UserDataPreferences,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", userData.accessToken)
            .build()
        return chain.proceed(request)
    }
}