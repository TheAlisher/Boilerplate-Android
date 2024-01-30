package com.alish.boilerplate.data.network.dtos

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.domain.models.Foo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FooDto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, name)
}