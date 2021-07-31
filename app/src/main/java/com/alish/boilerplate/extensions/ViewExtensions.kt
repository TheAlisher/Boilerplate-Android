package com.alish.boilerplate.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView


// region SearchView

/**
 * SearchView Extensions
 */

fun View.setSearchOnViewClickListener(listener: View.OnClickListener) {
    if (this is ViewGroup) {
        val count = childCount
        for (i in 0 until count) {
            val child: View = getChildAt(i)
            if (child is LinearLayout || child is RelativeLayout) {
                child.setSearchOnViewClickListener(listener)
            }
            if (child is TextView) {
                child.isFocusable = false
            }
            child.setOnClickListener(listener)
        }
    }
}

// endregion