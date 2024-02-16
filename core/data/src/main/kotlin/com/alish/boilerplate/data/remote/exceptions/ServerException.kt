package com.alish.boilerplate.data.remote.exceptions

sealed class ServerException : Exception() {

    class ApiException(override val message: String) : ServerException()

    class ApiInputException(val data: Map<String, List<String>>) : ServerException()
}
