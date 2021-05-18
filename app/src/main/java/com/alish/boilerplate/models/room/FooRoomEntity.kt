package com.alish.boilerplate.models.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FooRoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val bar: BarSubRoomEntity
)