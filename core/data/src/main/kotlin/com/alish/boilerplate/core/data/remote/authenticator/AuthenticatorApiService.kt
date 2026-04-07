package com.alish.boilerplate.core.data.remote.authenticator

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticatorApiService {

    @POST("/api/refreshtoken")
    suspend fun refreshToken(@Body refreshToken: RefreshToken): Tokens
}