package com.alish.boilerplate.data.network.dto

import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.domain.models.Bar
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BarDto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
) : DataMapper<Bar> {

    override fun mapToDomain() = Bar(id, name)
}