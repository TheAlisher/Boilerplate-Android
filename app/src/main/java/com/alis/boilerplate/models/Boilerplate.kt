package com.alis.boilerplate.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Boilerplate(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("foo")
    val foo: String,
    @SerializedName("bar")
    val bar: Int,
    @SerializedName("baz")
    val baz: Int
)