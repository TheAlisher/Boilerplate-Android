package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.FooDao
import com.alish.boilerplate.data.network.apiservices.FooApiService

class KoinRepository(
    private val fooApiService: FooApiService,
    private val fooDao: FooDao
) {
    // …
}