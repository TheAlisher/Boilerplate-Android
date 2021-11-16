package com.alish.boilerplate.data.network.authenticator

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.common.constants.Constants
import com.alish.boilerplate.data.network.interceptors.LoggingInterceptor
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

class TokenAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        /*
        if (response.request.header("Authorization") != null) {
            return null // Give up, we've already attempted to authenticate.
        }
        */

        val newToken = ""

        return response
            .request
            .newBuilder()
            .header("Authorization", "Bearer $newToken")
            .build()
    }
}

class TokenAuthenticatorRetrofitClient {

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

    fun provideTokenAuthenticatorApiService(): TokenAuthenticatorApiService = provideRetrofit
        .create(TokenAuthenticatorApiService::class.java)
}

interface TokenAuthenticatorApiService {

    @POST("/api/refreshtoken")
    fun refreshToken(@Body refreshToken: RefreshToken): Tokens
}

class RefreshToken(
    val refreshToken: String
)

class Tokens(
    val accessToken: String,
    val refreshToken: String
)

object TokenErrorListener : MutableLiveData<String>()