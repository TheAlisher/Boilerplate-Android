package com.alish.boilerplate.data.local.db.entities.foo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.models.foo.Foo

@Entity(tableName = "foo")
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}

fun FooDto.toEntity() = FooEntity(id, bar)