package com.alish.boilerplate.data.remote.authenticator

import com.alish.boilerplate.common.constants.Constants
import com.alish.boilerplate.data.remote.interceptors.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticatorModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(LoggingInterceptor().provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideAuthenticatorRetrofitClient(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideAuthenticatorApiService(retrofit: Retrofit) = retrofit
        .create(AuthenticatorApiService::class.java)
}