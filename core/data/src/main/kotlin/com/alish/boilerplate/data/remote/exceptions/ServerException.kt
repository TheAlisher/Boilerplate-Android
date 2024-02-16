package com.alish.boilerplate.data.remote.exceptions

import java.io.IOException

sealed class ServerException : IOException() {

    class ApiInputs(val data: Map<String, List<String>>) : ServerException()

    class Api(override val message: String) : ServerException()
}