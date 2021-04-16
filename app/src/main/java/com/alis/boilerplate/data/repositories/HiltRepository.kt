package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomFooDao
import com.alis.boilerplate.data.network.ktor.KtorFooApiService
import com.alis.boilerplate.data.network.retrofit.RetrofitFooApiService
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val retrofitApiService: RetrofitFooApiService,
    private val ktorApiService: KtorFooApiService,
    private val roomDao: RoomFooDao
) {
    // …
}