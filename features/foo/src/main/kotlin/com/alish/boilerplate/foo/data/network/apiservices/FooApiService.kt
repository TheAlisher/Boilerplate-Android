package com.alish.boilerplate.foo.data.network.apiservices

import com.alish.boilerplate.foo.data.network.dtos.FooDto
import com.alish.boilerplate.data.core.base.BoilerplatePagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): Response<FooDto>

    @GET("/api/foo")
    suspend fun fetchPrimitives(): Response<String>

    @GET("/api/foo")
    suspend fun fetchFooList(): Response<List<FooDto>>

    @GET("/api/foo")
    suspend fun fetchFooPaging(@Query("page") page: Int): Response<BoilerplatePagingResponse<FooDto>>
}