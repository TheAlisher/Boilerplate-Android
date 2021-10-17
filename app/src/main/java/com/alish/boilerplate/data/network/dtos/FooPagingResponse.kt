package com.alish.boilerplate.data.network.dtos

data class FooPagingResponse<T>(
    val prev: Int?,
    val next: Int?,
    val data: MutableList<T>
)