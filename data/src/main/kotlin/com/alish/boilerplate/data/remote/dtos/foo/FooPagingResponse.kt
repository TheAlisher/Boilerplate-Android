package com.alish.boilerplate.data.remote.dtos.foo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FooPagingResponse<T>(
    @Json(name = "prev")
    val prev: Int?,
    @Json(name = "next")
    val next: Int?,
    @Json(name = "data")
    val data: MutableList<T>
)