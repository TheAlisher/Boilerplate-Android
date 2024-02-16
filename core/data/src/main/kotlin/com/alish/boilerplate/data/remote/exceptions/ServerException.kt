package com.alish.boilerplate.data.remote.exceptions

import java.io.IOException

sealed class ServerException : IOException() {

    class ApiInputsException(val data: Map<String, List<String>>) : ServerException()

    class ApiException(override val message: String) : ServerException()
}