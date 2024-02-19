package com.alish.boilerplate.foo.data.network.models

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.foo.data.db.models.FooDBO
import com.alish.boilerplate.foo.domain.models.Foo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FooDTO(
    @Json(name = "id")
    val id: Long,
    @Json(name = "bar")
    val bar: String
) : DataMapper<Foo> {

    override fun toDomain() = Foo(id, bar)

    fun toDBO() = FooDBO(id, bar)
}