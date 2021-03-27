package com.alis.boilerplate.data.network

import com.alis.boilerplate.models.Boilerplate
import com.alis.boilerplate.models.BoilerplateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BoilerplateService {

    @GET("/api/boilerplate")
    suspend fun fetchBoilerplate(
        @Query("page") page: Int
    ): Response<BoilerplateResponse<Boilerplate>>
}