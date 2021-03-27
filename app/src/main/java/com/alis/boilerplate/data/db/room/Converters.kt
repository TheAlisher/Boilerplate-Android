package com.alis.boilerplate.data.db.room

import androidx.room.TypeConverter
import com.alis.boilerplate.models.room.BarSubRoomEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private inline fun <reified T> type() = object : TypeToken<T>() {}.type

    private inline fun <reified T> fromJson(value: String?): T? {
        return Gson().fromJson(value, type<T>())
    }

    private inline fun <reified T> toJson(generic: T?): String? {
        return Gson().toJson(generic, type<T>())
    }


    @TypeConverter
    fun fromJsonToBarSubRoomEntity(value: String?) = fromJson<BarSubRoomEntity>(value)

    @TypeConverter
    fun toJsonFromBarSubRoomEntity(barSubRoomEntity: BarSubRoomEntity) = toJson(barSubRoomEntity)
}