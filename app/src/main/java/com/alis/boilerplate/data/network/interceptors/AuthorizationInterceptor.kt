package com.alis.boilerplate.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "preference.getAccessToken()")
            .build()
        return chain.proceed(request)
    }
}