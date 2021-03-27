package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomFooDao
import com.alis.boilerplate.data.network.ktor.KtorFooService
import com.alis.boilerplate.data.network.retrofit.RetrofitFooService
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val retrofitService: RetrofitFooService,
    private val ktorService: KtorFooService,
    private val roomDao: RoomFooDao
) {
    // …
}