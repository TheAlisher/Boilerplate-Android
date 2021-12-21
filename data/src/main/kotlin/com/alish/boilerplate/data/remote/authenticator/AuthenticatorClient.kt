package com.alish.boilerplate.data.remote.authenticator

import com.alish.boilerplate.common.constants.Constants
import com.alish.boilerplate.data.remote.interceptors.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AuthenticatorClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val provideAuthenticatorRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAuthenticatorApiService(): AuthenticatorApiService = provideAuthenticatorRetrofit
        .create(AuthenticatorApiService::class.java)
}