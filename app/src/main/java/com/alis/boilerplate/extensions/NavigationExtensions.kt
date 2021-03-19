package com.alis.boilerplate.extensions

import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun View.navigate(actionID: Int) {
    setOnClickListener(Navigation.createNavigateOnClickListener(actionID))
}

fun View.navigate(directions: NavDirections) {
    setOnClickListener(Navigation.createNavigateOnClickListener(directions))
}

fun Fragment.overrideOnBackPressed(onBackPressed: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}