package com.alish.boilerplate.foo.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.core.data.utils.DataMapper
import com.alish.boilerplate.foo.domain.model.Foo

@Entity(tableName = "foo")
class FooDBO(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<Foo> {

    override fun asDomain() = Foo(id, bar)
}