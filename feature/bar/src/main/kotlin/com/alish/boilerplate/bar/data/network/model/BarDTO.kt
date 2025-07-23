package com.alish.boilerplate.bar.data.network.model

import com.alish.boilerplate.core.data.utils.DataMapper
import com.alish.boilerplate.bar.data.db.model.BarDBO
import com.alish.boilerplate.bar.domain.model.Bar
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BarDTO(
    @SerialName("id")
    val id: Long,
    @SerialName("baz")
    val baz: String
): DataMapper<Bar> {

    override fun toDomain() = Bar(
        id = id,
        baz = baz
    )

    fun toDBO() = BarDBO(
        id = id,
        baz = baz
    )
}