package com.alis.boilerplate.data.network.resource

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean = false
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data, isLoading = true)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}