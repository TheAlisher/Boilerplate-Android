package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.remote.interceptors.LoggingInterceptor
import com.alish.boilerplate.data.remote.authenticator.TokenAuthenticator
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OkHttp @Inject constructor() {

    fun provideOkHttpClient(
        authenticator: TokenAuthenticator?
    ) = OkHttpClient()
        .newBuilder()
        .authenticator(authenticator ?: Authenticator.NONE)
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

class RetrofitClient @Inject constructor() {

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}