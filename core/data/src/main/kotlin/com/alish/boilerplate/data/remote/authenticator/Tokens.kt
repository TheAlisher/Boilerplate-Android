package com.alish.boilerplate.data.remote.authenticator

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Tokens(
    @SerialName("access")
    val accessToken: String,
    @SerialName("refresh")
    val refreshToken: String
)

@Serializable
class RefreshToken(
    @SerialName("refresh")
    val refreshToken: String
)