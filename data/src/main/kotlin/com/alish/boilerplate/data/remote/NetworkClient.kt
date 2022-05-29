package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.okhttp.authenticator.TokenAuthenticator
import com.alish.boilerplate.data.remote.okhttp.interceptors.AuthorizationInterceptor
import javax.inject.Inject

class NetworkClient @Inject constructor(
    authenticator: TokenAuthenticator,
    authorizationInterceptor: AuthorizationInterceptor
) {

    private val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().apply {
            authenticator(authenticator)
            addInterceptor(authorizationInterceptor)
        }.build()
    )

    fun provideFooApiService(): FooApiService = provideRetrofit.create(
        FooApiService::class.java
    )

    class AuthenticatorClient @Inject constructor() {

        private val provideRetrofit = provideRetrofit(provideOkHttpClientBuilder().build())

        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideRetrofit.create(
            AuthenticatorApiService::class.java
        )
    }
}