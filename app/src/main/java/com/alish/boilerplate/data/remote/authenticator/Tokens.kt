package com.alish.boilerplate.data.remote.authenticator

class Tokens(
    val accessToken: String,
    val refreshToken: String
)

class RefreshToken(
    val refreshToken: String
)