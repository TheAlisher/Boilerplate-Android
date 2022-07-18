package com.alish.boilerplate.presentation.extensions

import androidx.fragment.app.Fragment
import com.alish.boilerplate.domain.utils.NetworkError
import com.google.android.material.textfield.TextInputLayout

fun NetworkError.setupApiErrors(vararg inputs: TextInputLayout) {
    if (this is NetworkError.Api) {
        for (input in inputs) {
            error[input.tag].also { error ->
                if (error == null) {
                    input.isErrorEnabled = false
                } else {
                    input.error = error.joinToString()
                    this.error.remove(input.tag)
                }
            }
        }
    }
}

fun NetworkError.setupUnexpectedErrors(fragment: Fragment) {
    if (this is NetworkError.Unexpected) {
        fragment.showToastLong(error)
    }
}