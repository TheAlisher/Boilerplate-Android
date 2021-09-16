package com.alish.boilerplate.extensions

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.alish.boilerplate.data.resource.Resource
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun <T> Resource.Error<T>.showError(fragment: Fragment) {
    message?.let { error -> fragment.showToastLong(error) }
}

fun TextInputEditText.disableErrorWhenStartWrite(inputLayout: TextInputLayout) {
    doOnTextChanged { _, _, _, _ ->
        inputLayout.isErrorEnabled = false
    }
}