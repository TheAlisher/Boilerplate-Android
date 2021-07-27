package com.alish.boilerplate.extensions

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun String.isValidJSON(): Boolean {
    try {
        JSONObject(this)
    } catch (exception: JSONException) {
        try {
            JSONArray(this)
        } catch (exception: JSONException) {
            return false
        }
    }
    return true
}