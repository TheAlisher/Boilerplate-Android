package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.RoomFooDao
import com.alish.boilerplate.data.network.retrofit.apiservices.RetrofitFooApiService

class KoinRepository(
    private val retrofitApiService: RetrofitFooApiService,
    private val roomDao: RoomFooDao
) {
    // …
}