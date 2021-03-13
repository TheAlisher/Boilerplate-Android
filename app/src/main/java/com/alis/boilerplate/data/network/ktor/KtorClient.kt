package com.alis.boilerplate.data.network.ktor

import com.alis.boilerplate.constants.NetworkConstants
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class KtorClient {

    private val client = HttpClient(OkHttp) {
        defaultRequest {
            host = NetworkConstants.HOST
            url {
                protocol = URLProtocol.HTTPS
            }
        }

        install(JsonFeature) {
            serializer = GsonSerializer()
        }

        engine {
            addInterceptor(provideLoggingInterceptor())

            config {
                connectTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                writeTimeout(30, TimeUnit.SECONDS)
            }
        }
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    fun provideKtor() = client
}