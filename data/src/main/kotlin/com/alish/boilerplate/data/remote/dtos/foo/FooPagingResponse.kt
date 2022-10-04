package com.alish.boilerplate.data.remote.dtos.foo

import com.google.gson.annotations.SerializedName

class FooPagingResponse<T>(
    @SerializedName("prev")
    val prev: Int?,
    @SerializedName("next")
    val next: Int?,
    @SerializedName("data")
    val data: MutableList<T>
)