package com.alish.boilerplate.presentation.core.extensions

import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Get text with [toString] & [trim] from Input
 */
val TextInputEditText.fullText: String get() = this.text.toString().trim()

/**
 * @receiver [ViewGroup]
 * @return [List] with [TextInputLayout] in fragments xml
 */
fun ViewGroup.getChildInputLayouts(): List<TextInputLayout> {
    val inputs = mutableListOf<TextInputLayout>()
    for (i in 0 until childCount) {
        val childView = getChildAt(i)
        if (childView is TextInputLayout) {
            inputs.add(childView)
        }
        val childViewGroup = childView as? ViewGroup
        if (childViewGroup !is TextInputLayout) {
            childViewGroup?.getChildInputLayouts()
        }
    }
    return inputs
}