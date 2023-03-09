package com.alish.boilerplate.data.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Fast get object type
 */
private inline fun <reified T> type() = object : TypeToken<T>() {}.type

/**
 * Convert from json
 *
 * @return [T] our model
 */
internal inline fun <reified T> fromJson(value: String): T {
    return Gson().fromJson(value, type<T>())
}

/**
 * Convert to json
 *
 * @return [String] json in string
 */
internal inline fun <reified T> toJson(generic: T?): String? {
    return Gson().toJson(generic, type<T>())
}

/**
 * Get Json from [assets][Context.getAssets]
 *
 * @return Json file from [assets][Context.getAssets]
 */
internal fun Context.jsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}