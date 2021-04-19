package com.alis.boilerplate.extensions

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


// region Fragment

/**
 * Fragment Extensions
 */

fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToastShort(textFromResource: Int) {
    Toast.makeText(context, textFromResource, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToastLong(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

fun Fragment.showToastLong(textFromResource: Int) {
    Toast.makeText(context, textFromResource, Toast.LENGTH_LONG).show()
}

// endregion


// region View

/**
 * View Extensions
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

// endregion