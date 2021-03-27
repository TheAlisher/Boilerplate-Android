package com.alis.boilerplate.models

data class BoilerplateResponse<T>(
    val prev: Int?,
    val next: Int?,
    val data: MutableList<T>
)