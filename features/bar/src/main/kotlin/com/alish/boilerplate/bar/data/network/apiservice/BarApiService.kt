package com.alish.boilerplate.bar.data.network.apiservice

import com.alish.boilerplate.bar.data.network.model.BarDTO
import retrofit2.Response
import retrofit2.http.GET

interface BarApiService {

    @GET("/api/bar")
    suspend fun fetchBar(): Response<BarDTO>
}