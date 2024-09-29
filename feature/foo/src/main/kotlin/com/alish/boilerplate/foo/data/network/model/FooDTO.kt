package com.alish.boilerplate.foo.data.network.model

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.data.core.utils.DatabaseMapper
import com.alish.boilerplate.data.core.utils.DateSerializer
import com.alish.boilerplate.foo.data.db.model.FooDBO
import com.alish.boilerplate.foo.domain.model.Foo
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
) : DataMapper<Foo>, DatabaseMapper<FooDBO> {

    override fun toDomain() = Foo(id, bar)

    override fun asDBO() = FooDBO(id, bar)
}