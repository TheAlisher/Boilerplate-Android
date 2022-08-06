package com.alish.boilerplate.data.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Convert Json file to [T] (our model)
 *
 * @return [T]
 */
inline fun <reified T> fromJson(file: String): T {
    return Gson().fromJson(file, object : TypeToken<T>() {}.type)
}

/**
 * Get Json from assets package
 *
 * @return Json file from assets
 */
fun Context.jsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}