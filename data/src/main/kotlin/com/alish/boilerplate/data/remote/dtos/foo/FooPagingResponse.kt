package com.alish.boilerplate.data.remote.dtos.foo

data class FooPagingResponse<T>(
    val prev: Int?,
    val next: Int?,
    val data: MutableList<T>
)