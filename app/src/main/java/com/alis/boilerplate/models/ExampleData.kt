package com.alis.boilerplate.models

import androidx.room.PrimaryKey

data class ExampleData(
    @PrimaryKey
    val id: Long,
    val title: String,
    val description: String?
)