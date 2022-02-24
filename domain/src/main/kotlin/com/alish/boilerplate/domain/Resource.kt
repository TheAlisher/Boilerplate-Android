package com.alish.boilerplate.domain

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(data: T? = null, message: String) : Resource<T>(data = data, message = message)
    class Success<T>(data: T) : Resource<T>(data = data)
}