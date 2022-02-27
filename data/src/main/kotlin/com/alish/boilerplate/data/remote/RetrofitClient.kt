package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.interceptors.LoggingInterceptor
import com.alish.boilerplate.data.remote.apiservices.FooApiService
import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    authenticator: TokenAuthenticator
) {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .authenticator(authenticator)
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideFooApiService(): FooApiService = provideRetrofit.create(
        FooApiService::class.java
    )

    class Authenticator {

        private val okHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        private val provideAuthenticatorRetrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideAuthenticatorRetrofit
            .create(AuthenticatorApiService::class.java)
    }
}