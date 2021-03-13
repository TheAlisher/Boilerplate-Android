package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.RoomDao
import com.alis.boilerplate.data.network.ktor.KtorRequests
import com.alis.boilerplate.data.network.retrofit.API
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val api: API,
    private val request: KtorRequests,
    private val roomDao: RoomDao
) {
    // …
}