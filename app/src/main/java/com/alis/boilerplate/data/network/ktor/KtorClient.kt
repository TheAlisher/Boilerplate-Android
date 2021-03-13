package com.alis.boilerplate.data.network.ktor

import com.alis.boilerplate.constants.NetworkConstants
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorClient {

    private val client = HttpClient {
        defaultRequest {
            host = NetworkConstants.HOST
            url {
                protocol = URLProtocol.HTTPS
            }
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    fun provideKtor() = client
}