package com.alish.boilerplate.data.remote

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.dtos.tokens.RefreshToken
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient @Inject constructor() {

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

class OkHttp @Inject constructor() {

    fun provideOkHttpClient(
        authenticator: TokenAuthenticator?
    ) = OkHttpClient()
        .newBuilder()
        .authenticator(authenticator ?: Authenticator.NONE)
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    class AuthorizationInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization", "preference.getAccessToken()")
                .build()
            return chain.proceed(request)
        }
    }
}

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val tokenErrorListener: MutableLiveData<String>
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val refreshToken = service.refreshToken(RefreshToken("<refresh_token>")).execute()

            return when {
                refreshToken.isSuccessful -> {
                    // save token to preferences

                    response
                        .request
                        .newBuilder()
                        .header("Authorization", "Bearer <new_access_token>")
                        .build()
                }
                refreshToken.code() == 403 -> {
                    tokenErrorListener.postValue("Error")
                    null
                }
                else -> {
                    null
                }
            }
        }
    }
}