package com.alish.boilerplate.data.network.apiservice

import com.alish.boilerplate.data.network.dto.BazDto
import retrofit2.Response
import retrofit2.http.GET

interface BazApiService {

    @GET("/api/baz")
    suspend fun fetchBaz(): Response<BazDto>
}