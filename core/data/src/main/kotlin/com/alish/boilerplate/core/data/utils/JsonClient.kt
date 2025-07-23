package com.alish.boilerplate.core.data.utils

import android.content.Context
import kotlinx.serialization.json.Json

internal val jsonClient = Json {
    prettyPrint = true
}

/**
 * Get Json from [assets][Context.getAssets]
 *
 * @return Json file from [assets][Context.getAssets]
 */
internal fun Context.jsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}