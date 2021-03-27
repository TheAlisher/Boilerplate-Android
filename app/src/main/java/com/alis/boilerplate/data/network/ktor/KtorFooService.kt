package com.alis.boilerplate.data.network.ktor

import io.ktor.client.*

class KtorFooService(
    private val client: HttpClient
) {
    // …
}