package com.alish.boilerplate.data.local.db.entities.foo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.domain.models.foo.Foo

@Entity
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
)

fun FooEntity.toFoo() = Foo(id, bar)