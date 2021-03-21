package com.alis.boilerplate.models.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
)