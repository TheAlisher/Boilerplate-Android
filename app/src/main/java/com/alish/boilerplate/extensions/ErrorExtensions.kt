package com.alish.boilerplate.extensions

import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputEditText.disableErrorWhenStartWrite(inputLayout: TextInputLayout) {
    doOnTextChanged { _, _, _, _ ->
        inputLayout.isErrorEnabled = false
    }
}