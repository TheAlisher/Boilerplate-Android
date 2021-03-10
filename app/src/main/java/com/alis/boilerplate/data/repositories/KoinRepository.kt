package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomDao
import com.alis.boilerplate.data.network.retrofit.API

class KoinRepository(
    private val api: API,
    private val roomDao: RoomDao
) {
    // …
}