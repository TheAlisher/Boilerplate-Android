package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomFooDao
import com.alis.boilerplate.data.network.ktor.KtorFooService
import com.alis.boilerplate.data.network.retrofit.RetrofitFooService

class KoinRepository(
    private val retrofitService: RetrofitFooService,
    private val ktorService: KtorFooService,
    private val roomDao: RoomFooDao
) {
    // …
}