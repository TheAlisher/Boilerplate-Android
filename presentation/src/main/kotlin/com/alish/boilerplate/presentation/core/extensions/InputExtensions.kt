package com.alish.boilerplate.presentation.core.extensions

import com.google.android.material.textfield.TextInputEditText

/**
 * Get text with [toString] & [trim] from Input
 */
val TextInputEditText.fullText: String get() = this.text.toString().trim()