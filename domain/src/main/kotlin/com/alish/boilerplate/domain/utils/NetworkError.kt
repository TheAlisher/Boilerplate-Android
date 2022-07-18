package com.alish.boilerplate.domain.utils

sealed class NetworkError {
    class Api(val apiError: MutableMap<String, List<String>>) : NetworkError()
    class Unexpected(val unexpectedError: String) : NetworkError()
}
