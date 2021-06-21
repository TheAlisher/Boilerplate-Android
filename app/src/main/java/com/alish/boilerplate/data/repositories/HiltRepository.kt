package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.RoomFooDao
import com.alish.boilerplate.data.network.retrofit.apiservices.RetrofitFooApiService
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val retrofitApiService: RetrofitFooApiService,
    private val roomDao: RoomFooDao
) {
    // …
}