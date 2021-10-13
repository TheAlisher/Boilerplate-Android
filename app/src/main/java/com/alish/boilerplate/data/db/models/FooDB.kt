package com.alish.boilerplate.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FooDB(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val bar: Bar
)