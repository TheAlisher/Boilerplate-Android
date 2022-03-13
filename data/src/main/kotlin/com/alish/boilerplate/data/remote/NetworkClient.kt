package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp,
    authenticator: TokenAuthenticator
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(
        okHttp.provideOkHttpClient(authenticator)
    )

    fun provideFooApiService() = provideRetrofit.create(
        FooApiService::class.java
    )

    class AuthenticatorClient @Inject constructor(
        retrofitClient: RetrofitClient,
        okHttp: OkHttp,
    ) {

        private val provideRetrofit = retrofitClient.provideRetrofit(
            okHttp.provideOkHttpClient(null)
        )

        fun provideAuthenticatorApiService() = provideRetrofit.create(
            AuthenticatorApiService::class.java
        )
    }
}