package com.alish.boilerplate.foo.data.network.dtos

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.foo.domain.models.Foo
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