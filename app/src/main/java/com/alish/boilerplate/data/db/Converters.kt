package com.alish.boilerplate.data.db

import androidx.room.TypeConverter
import com.alish.boilerplate.data.db.models.Bar
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
    fun jsonToBar(value: String?) = fromJson<Bar>(value)

    @TypeConverter
    fun barToJson(bar: Bar) = toJson(bar)
}