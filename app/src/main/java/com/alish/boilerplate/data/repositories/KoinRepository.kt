package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.RoomFooDao
import com.alish.boilerplate.data.network.ktor.apiservices.KtorFooApiService
import com.alish.boilerplate.data.network.retrofit.apiservices.RetrofitFooApiService

class KoinRepository(
    private val retrofitApiService: RetrofitFooApiService,
    private val ktorApiService: KtorFooApiService,
    private val roomDao: RoomFooDao
) {
    // …
}