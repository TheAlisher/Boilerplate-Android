package com.alish.boilerplate.data.remote.exceptions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.IOException

/**
 * Sealed class representing exceptions that can occur on the server.
 */
sealed class ServerException : IOException() {

    /**
     * Represents an [internal server error](https://http.cat/status/500).
     */
    data object InternalServerError : ServerException()

    /**
     * Represents a [service unavailable error](https://http.cat/status/503).
     */
    data object ServiceUnavailable : ServerException()

    /**
     * Represents an API error with specific inputs.
     *
     * @property data The data associated with the API error, typically containing input validation errors.
     */
    @Serializable
    class ApiInputs(@SerialName("data") val data: Map<String, List<String>>) : ServerException()

    /**
     * Represents a generic API error with a custom message.
     *
     * @param message The error message.
     */
    @Serializable
    class Api(@SerialName("message") override val message: String) : ServerException()

    companion object {

        /**
         * Get a [ServerException] corresponding to the given HTTP status code.
         *
         * @param code The HTTP status code.
         * @return The corresponding [ServerException], or a generic [IOException] if no match is found.
         */
        fun getByHTTPCats(code: Int): IOException = when (code) {
            500 -> InternalServerError
            503 -> ServiceUnavailable
            else -> IOException()
        }
    }
}