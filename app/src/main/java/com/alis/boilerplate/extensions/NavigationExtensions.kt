package com.alis.boilerplate.extensions

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun View.navigate(@IdRes actionID: Int) {
    setOnClickListener(Navigation.createNavigateOnClickListener(actionID))
}

fun View.navigate(directions: NavDirections) {
    setOnClickListener(Navigation.createNavigateOnClickListener(directions))
}

fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback. () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}