package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomDao
import com.alis.boilerplate.data.network.ktor.FooRequests
import com.alis.boilerplate.data.network.retrofit.FooAPI

class KoinRepository(
    private val fooAPI: FooAPI,
    private val fooRequests: FooRequests,
    private val roomDao: RoomDao
) {
    // …
}