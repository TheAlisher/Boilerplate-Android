package com.alis.boilerplate.data.network.paging

import com.alis.boilerplate.models.paging.FooPagingData
import com.alis.boilerplate.models.paging.FooPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooPagingApiService {

    @GET("/api/foo")
    suspend fun fetchFooPagingData(
        @Query("page") page: Int
    ): Response<FooPagingResponse<FooPagingData>>
}