package com.alish.boilerplate.data.remote.client

import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.client.authenticator.TokenAuthenticator
import com.alish.boilerplate.data.remote.client.interceptors.AuthorizationInterceptor
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