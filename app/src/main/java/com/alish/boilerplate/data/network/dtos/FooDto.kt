package com.alish.boilerplate.data.network.dtos

import com.alish.boilerplate.domain.models.Foo
import com.google.gson.annotations.SerializedName

class FooDto(

    @SerializedName("id")
    val id: Long,

    @SerializedName("bar")
    val bar: String
)

fun FooDto.toFoo(): Foo {
    return Foo(id, bar)
}