package com.alish.boilerplate.common.extensions

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.navigateSafely(@IdRes actionId: Int) {
    try {
        navigate(actionId)
    } catch (exception: IllegalArgumentException) {
        loggingNavigateSafely(exception)
    }
}

fun NavController.navigateSafely(directions: NavDirections) {
    try {
        navigate(directions)
    } catch (exception: IllegalArgumentException) {
        loggingNavigateSafely(exception)
    }
}

private fun loggingNavigateSafely(exception: IllegalArgumentException) {
    Log.wtf("NavigateSafely", "This is a normal exception, do not pay attention", exception)
}

fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback. () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}