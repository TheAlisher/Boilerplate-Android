package com.alish.boilerplate.data.network.apiservices

import com.alish.boilerplate.models.paging.FooPagingData
import com.alish.boilerplate.models.paging.FooPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooPagingApiService {

    @GET("/api/foo")
    suspend fun fetchFooPaging(
        @Query("page") page: Int
    ): Response<FooPagingResponse<FooPagingData>>
}