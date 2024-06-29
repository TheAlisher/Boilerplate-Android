package com.alish.boilerplate.bar.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alish.boilerplate.data.core.utils.DataMapper
import com.alish.boilerplate.bar.domain.model.Bar

@Entity(tableName = "bar")
class BarDBO(
    @PrimaryKey
    val id: Long,
    val baz: String
) : DataMapper<Bar> {

    override fun toDomain() = Bar(
        id = id,
        baz = baz
    )
}