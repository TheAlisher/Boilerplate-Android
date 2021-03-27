package com.alis.boilerplate.models

data class BoilerplateResponse(
    val prev: Int,
    val next: Int,
    val boilerplate: MutableList<Boilerplate>
)