package com.alish.boilerplate.data.network.retrofit

import com.alish.boilerplate.constants.Constants
import com.alish.boilerplate.data.network.okhttp.interceptors.LoggingInterceptor
import com.alish.boilerplate.data.network.retrofit.apiservices.FooApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideFooApiService(): FooApiService = provideRetrofit
        .create(FooApiService::class.java)
}