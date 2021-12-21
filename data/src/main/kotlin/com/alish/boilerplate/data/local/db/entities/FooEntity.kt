package com.alish.boilerplate.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.domain.models.Foo

@Entity
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
)

fun FooEntity.toFoo() = Foo(id, bar)