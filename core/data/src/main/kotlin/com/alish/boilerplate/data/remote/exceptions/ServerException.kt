package com.alish.boilerplate.data.remote.exceptions

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.IOException

@JsonClass(generateAdapter = true)
sealed class ServerException : IOException() {

    @JsonClass(generateAdapter = true)
    class ApiInputs(
        @Json(name = "data")
        val data: Map<String, List<String>>
    ) : ServerException()

    @JsonClass(generateAdapter = true)
    class Api(
        @Json(name = "message")
        override val message: String
    ) : ServerException()
}