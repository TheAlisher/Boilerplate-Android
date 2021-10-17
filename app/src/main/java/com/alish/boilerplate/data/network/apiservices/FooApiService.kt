package com.alish.boilerplate.data.network.apiservices

import com.alish.boilerplate.data.network.dtos.FooDto
import com.alish.boilerplate.data.network.dtos.FooPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): FooDto

    @GET("/api/foo")
    suspend fun fetchFooPaging(
        @Query("page") page: Int
    ): Response<FooPagingResponse<FooDto>>
}