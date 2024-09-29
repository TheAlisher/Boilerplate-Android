package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.core.utils.buildRetrofit
import com.alish.boilerplate.data.core.utils.createOkHttpClientBuilder
import com.alish.boilerplate.data.remote.authenticator.AuthenticatorApiService
import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import com.alish.boilerplate.data.remote.interceptors.AuthorizationInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkClient @Inject constructor(
    authenticator: TokenAuthenticator,
    authorizationInterceptor: AuthorizationInterceptor
) {

    val provideRetrofit = buildRetrofit(
        createOkHttpClientBuilder().apply {
            authenticator(authenticator)
            addInterceptor(authorizationInterceptor)
        }.build()
    )

    inline fun <reified T> provideApiService(): T = provideRetrofit.create(T::class.java)

    class AuthenticatorClient @Inject constructor() {

        private val provideRetrofit = buildRetrofit(
            createOkHttpClientBuilder().build()
        )

        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideRetrofit.create(
            AuthenticatorApiService::class.java
        )
    }
}