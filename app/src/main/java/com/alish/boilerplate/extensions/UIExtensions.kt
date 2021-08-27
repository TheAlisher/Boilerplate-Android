package com.alish.boilerplate.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.alish.boilerplate.data.resource.Resource


// region Fragment

/**
 * Fragment Extensions
 */

fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToastShort(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToastLong(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

fun Fragment.showToastLong(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_LONG).show()
}

// endregion


// region Views

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


// region Resource

/**
 * Resource Extensions
 */

fun <T> ProgressBar.bindToResourceLoading(resource: Resource<T>) {
    isVisible = resource is Resource.Loading
}

fun <T> ViewGroup.bindToResourceNotLoading(resource: Resource<T>) {
    isVisible = resource !is Resource.Loading
}

fun <T> ConstraintHelper.bindToResourceNotLoading(resource: Resource<T>) {
    isVisible = resource !is Resource.Loading
}

// endregion