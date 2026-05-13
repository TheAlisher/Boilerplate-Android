package com.alish.boilerplate.bar.data.network.model

import com.alish.boilerplate.core.data.utils.DataMapper
import com.alish.boilerplate.bar.data.db.model.BarDBO
import com.alish.boilerplate.bar.domain.model.Bar
import com.alish.boilerplate.core.data.utils.DatabaseMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BarDTO(
    @SerialName("id")
    val id: Long,
    @SerialName("baz")
    val baz: String
): DataMapper<Bar>, DatabaseMapper<BarDBO> {

    override fun asDomain() = Bar(
        id = id,
        baz = baz
    )

    override fun asDBO() = BarDBO(
        id = id,
        baz = baz
    )
}