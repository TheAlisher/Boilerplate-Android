package com.alis.boilerplate.data.db.room

import androidx.room.TypeConverter
import com.alis.boilerplate.models.room.SubRoomEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.sql.Date

class Converters {

    private inline fun <reified T> type() = object : TypeToken<T>() {}.type

    private inline fun <reified T> fromJson(value: String?): T? {
        return Gson().fromJson(value, type<T>())
    }

    private inline fun <reified T> toJson(generic: T?): String? {
        return Gson().toJson(generic, type<T>())
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromSubRoomEntity(value: String?) = fromJson<SubRoomEntity>(value)

    @TypeConverter
    fun subRoomEntityToJson(subRoomEntity: SubRoomEntity) = toJson(subRoomEntity)
}