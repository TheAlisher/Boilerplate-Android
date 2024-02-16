package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.remote.authenticator.AuthenticatorApiService
import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import com.alish.boilerplate.data.remote.interceptors.AuthorizationInterceptor
import com.alish.boilerplate.data.remote.interceptors.ServerErrorInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkClient @Inject constructor(
	authenticator: TokenAuthenticator,
	authorizationInterceptor: AuthorizationInterceptor,
    serverErrorInterceptor: ServerErrorInterceptor
) {

    val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().apply {
            authenticator(authenticator)
            addInterceptor(authorizationInterceptor)
            addInterceptor(serverErrorInterceptor)
        }.build()
    )

    inline fun <reified T> provide(): T = provideRetrofit.create(T::class.java)

    class AuthenticatorClient @Inject constructor() {

        private val provideRetrofit = provideRetrofit(provideOkHttpClientBuilder().build())

        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideRetrofit.create(
            AuthenticatorApiService::class.java
        )
    }
}