package com.alish.boilerplate.extensions

import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView

fun SearchView.setSearchViewOnClickListener(listener: View.OnClickListener) {
    val count = this.childCount
    for (i in 0 until count) {
        val child: View = this.getChildAt(i)
        if (child is LinearLayout || child is RelativeLayout) {
            setSearchViewOnClickListener(listener)
        }
        if (child is TextView) {
            child.isFocusable = false
        }
        child.setOnClickListener(listener)
    }
}