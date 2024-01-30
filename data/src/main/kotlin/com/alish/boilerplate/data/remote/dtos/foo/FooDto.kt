package com.alish.boilerplate.data.remote.dtos.foo

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.domain.models.foo.Foo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FooDto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "bar")
    val bar: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}