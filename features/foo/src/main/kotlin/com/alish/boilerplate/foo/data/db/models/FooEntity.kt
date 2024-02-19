package com.alish.boilerplate.foo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.foo.data.network.models.FooDTO
import com.alish.boilerplate.foo.domain.models.Foo

@Entity(tableName = "foo")
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}

fun FooDTO.toEntity() = FooEntity(id, bar)