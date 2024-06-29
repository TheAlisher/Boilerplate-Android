package com.alish.boilerplate.foo.data.network.models

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.data.core.utils.DateSerializer
import com.alish.boilerplate.foo.data.db.models.FooDBO
import com.alish.boilerplate.foo.domain.models.Foo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
class FooDTO(
    @SerialName("id")
    val id: Long,
    @SerialName("bar")
    val bar: String,
    @SerialName("date")
    @Serializable(DateSerializer::class)
    val date: Date
) : DataMapper<Foo> {

    override fun toDomain() = Foo(id, bar)

    fun toDBO() = FooDBO(id, bar)
}