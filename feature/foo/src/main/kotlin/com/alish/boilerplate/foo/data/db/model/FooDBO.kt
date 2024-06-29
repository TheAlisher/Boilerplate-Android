package com.alish.boilerplate.foo.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.foo.domain.model.Foo

@Entity(tableName = "foo")
class FooDBO(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<Foo> {

    override fun toDomain() = Foo(id, bar)
}