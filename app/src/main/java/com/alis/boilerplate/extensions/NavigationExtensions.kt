package com.alis.boilerplate.extensions

import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

val NavController.previousDestination
    get() = previousBackStackEntry?.destination

fun View.navigate(@IdRes actionId: Int) {
    setOnClickListener(Navigation.createNavigateOnClickListener(actionId))
}

fun View.navigate(directions: NavDirections) {
    setOnClickListener(Navigation.createNavigateOnClickListener(directions))
}

fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback. () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}

fun NavController.navigateSafely(@IdRes actionId: Int) {
    try {
        navigate(actionId)
    } catch (E: IllegalArgumentException) {
        loggingNavigateSafely(E)
    }
}

fun NavController.navigateSafely(directions: NavDirections) {
    try {
        navigate(directions)
    } catch (E: IllegalArgumentException) {
        loggingNavigateSafely(E)
    }
}

private fun loggingNavigateSafely(E: IllegalArgumentException) {
    Log.wtf("NavigateSafely", "This is a normal exception, do not pay attention", E)
}