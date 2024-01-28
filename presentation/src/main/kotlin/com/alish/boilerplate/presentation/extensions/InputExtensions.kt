package com.alish.boilerplate.presentation.extensions

import com.google.android.material.textfield.TextInputEditText

val TextInputEditText.fullText: String
    get() = this.text.toString().trim()