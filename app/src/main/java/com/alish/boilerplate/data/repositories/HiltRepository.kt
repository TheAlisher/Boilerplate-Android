package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.FooDao
import com.alish.boilerplate.data.network.retrofit.apiservices.FooApiService
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val fooApiService: FooApiService,
    private val fooDao: FooDao
) {
    // …
}