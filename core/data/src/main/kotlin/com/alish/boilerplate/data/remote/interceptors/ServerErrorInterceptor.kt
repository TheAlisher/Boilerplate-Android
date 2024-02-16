package com.alish.boilerplate.data.remote.interceptors

import com.alish.boilerplate.data.core.utils.fromJson
import com.alish.boilerplate.data.remote.exceptions.ServerException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject

class ServerErrorInterceptor @Inject constructor() : Interceptor {

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
                throw IOException(response.message)
            }
        }
    }

    /**
     * Convert network error from server side
     *
     * @receiver [ResponseBody]
     * @throws NullPointerException if can not convert [errorBody][ResponseBody]
     * @see fromJson
     */
    private inline fun <reified T> ResponseBody?.toApiError(): T {
        return this?.let { fromJson<T>(it.string()) } ?: throw NullPointerException(
            "JsonUtil can not converted fromJson: ${T::class.java.simpleName}"
        )
    }
}