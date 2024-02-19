package com.alish.boilerplate.foo.data.network.apiservices

import com.alish.boilerplate.foo.data.network.models.FooDto
import com.alish.boilerplate.data.core.base.BasePagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): FooDto

    @GET("/api/foo")
    suspend fun fetchPrimitives(): String

    @GET("/api/foo")
    suspend fun fetchFooList(): List<FooDto>

    @GET("/api/foo")
    suspend fun fetchFooPaging(@Query("page") page: Int): Response<BasePagingResponse<FooDto>>
}