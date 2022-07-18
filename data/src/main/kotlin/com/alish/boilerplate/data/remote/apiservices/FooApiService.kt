package com.alish.boilerplate.data.remote.apiservices

import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import com.alish.boilerplate.data.remote.dtos.foo.FooPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): Response<FooDto>

    @GET("/api/foo")
    suspend fun fetchFooPaging(
        @Query("page") page: Int
    ): Response<FooPagingResponse<FooDto>>
}