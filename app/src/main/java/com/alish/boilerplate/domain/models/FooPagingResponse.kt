package com.alish.boilerplate.domain.models

data class FooPagingResponse<T>(
    val prev: Int?,
    val next: Int?,
    val data: MutableList<T>
)