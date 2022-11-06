package com.alish.boilerplate.data.remote.dtos.foo

import com.alish.boilerplate.data.utils.DataMapper
import com.alish.boilerplate.domain.models.foo.Foo
import com.google.gson.annotations.SerializedName

class FooDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("bar")
    val bar: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}