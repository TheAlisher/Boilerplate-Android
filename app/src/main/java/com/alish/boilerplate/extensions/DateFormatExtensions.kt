package com.alish.boilerplate.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.parseToFormat(parserPattern: String, formatterPattern: String): String {
    val parser = SimpleDateFormat(parserPattern, Locale.ENGLISH)
    val formatter = SimpleDateFormat(formatterPattern, Locale.ENGLISH)
    return formatter.format(parser.parse(this)!!)
}