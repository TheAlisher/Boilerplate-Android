package com.alish.boilerplate.data.core.utils

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.Date

/**
 * Moshi instance
 *
 * @see KotlinJsonAdapterFactory
 */
val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(Date::class.java, Rfc3339DateJsonAdapter())
    .build()

/**
 * Convert from json
 *
 * @return [T] our model
 */
internal inline fun <reified T> fromJson(value: String): T? {
    return moshi.adapter(T::class.java).fromJson(value)
}

/**
 * Convert to json
 *
 * @return [String] json in string
 */
internal inline fun <reified T> toJson(generic: T?): String {
    return moshi.adapter(T::class.java).toJson(generic)
}

/**
 * Get Json from [assets][Context.getAssets]
 *
 * @return Json file from [assets][Context.getAssets]
 */
internal fun Context.jsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}