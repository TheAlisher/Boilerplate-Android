package com.alish.boilerplate.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
)