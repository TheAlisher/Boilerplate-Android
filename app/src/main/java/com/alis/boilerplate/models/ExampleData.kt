package com.alis.boilerplate.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class ExampleData(
    @PrimaryKey
    val id: Long,
    val title: String,
    val description: String?
)