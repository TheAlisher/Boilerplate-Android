package com.alish.boilerplate.foo.data.network.apiservice

import com.alish.boilerplate.foo.data.network.model.FooDTO
import com.alish.boilerplate.data.core.base.BasePagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): Response<FooDTO>

    @GET("/api/foo")
    suspend fun fetchPrimitives(): Response<String>

    @GET("/api/foo")
    suspend fun fetchFooList(): Response<List<FooDTO>>

    @GET("/api/foo")
    suspend fun fetchFooPaging(@Query("page") page: Int): Response<BasePagingResponse<FooDTO>>
}