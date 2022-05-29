package com.alish.boilerplate.data.remote

import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.local.preferences.PreferencesHelper
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.dtos.tokens.RefreshToken
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

internal fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
}

private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    when {
        BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }
)

class AuthorizationInterceptor @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "$preferencesHelper.getAccessToken()")
            .build()
        return chain.proceed(request)
    }
}

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val preferencesHelper: PreferencesHelper
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val refreshToken = service.refreshToken(RefreshToken("<refresh_token>")).execute()

            return when {
                refreshToken.isSuccessful -> {

                    // save token to preferences
                    preferencesHelper

                    response
                        .request
                        .newBuilder()
                        .header("Authorization", "Bearer $preferencesHelper.<new_access_token>")
                        .build()
                }
                else -> {
                    null
                }
            }
        }
    }
}