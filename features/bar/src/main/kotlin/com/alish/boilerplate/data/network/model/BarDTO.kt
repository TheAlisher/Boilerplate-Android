package com.alish.boilerplate.data.network.model

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.data.db.model.BarDBO
import com.alish.boilerplate.domain.model.Bar
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