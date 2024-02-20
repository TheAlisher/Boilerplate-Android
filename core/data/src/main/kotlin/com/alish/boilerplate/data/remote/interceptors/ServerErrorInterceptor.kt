package com.alish.boilerplate.data.remote.interceptors

import com.alish.boilerplate.data.core.utils.fromJson
import com.alish.boilerplate.data.remote.exceptions.ServerException
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * Interceptor for handling server errors during network requests.
 */
class ServerErrorInterceptor @Inject constructor() : Interceptor {

    /**
     * Intercepts the network request and handles server errors.
     *
     * @param chain The interceptor chain.
     * @return The response if successful, or throws an appropriate [ServerException] for encountered errors.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        when {
            response.isSuccessful -> {
                return response
            }

            !response.isSuccessful && response.code == 422 -> {
                throw response.body.toApiError<ServerException.ApiInputs>()
            }

            !response.isSuccessful -> {
                throw response.body.toApiError<ServerException.Api>()
            }

            else -> {
                throw ServerException.getByHTTPCats(response.code)
            }
        }
    }

    /**
     * Converts the response body to a specific API error type.
     *
     * @receiver [ResponseBody] The response body.
     * @return The API error object.
     * @throws NullPointerException if the response body cannot be converted.
     * @see fromJson
     */
    private inline fun <reified T> ResponseBody?.toApiError(): T {
        return this?.let { Json.decodeFromString<T>(it.string()) } ?: throw NullPointerException(
            "JsonUtil cannot convert fromJson: ${T::class.java.simpleName}"
        )
    }
}