package com.alish.boilerplate.data.core.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BasePagingResponse<T>(
    @SerialName("prev")
    val prev: Int?,
    @SerialName("next")
    val next: Int?,
    @SerialName("data")
    val data: MutableList<T>
)