package com.alish.boilerplate.data.remote.exceptions

sealed class ServerException : Exception() {

    class ApiInputException(val data: Map<String, List<String>>) : ServerException()

    class ApiException(override val message: String) : ServerException()
}
