package com.alish.boilerplate.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.data.network.dtos.FooDto
import com.alish.boilerplate.domain.models.Foo

@Entity(tableName = "foo")
class FooEntity(
    @PrimaryKey
    val id: Long,
    val name: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, name)
}

fun FooDto.toEntity() = FooEntity(id, name)