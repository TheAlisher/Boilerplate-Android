package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidateIsEmpty @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(email: String): ValidationResult {
        return when {
            email.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.field_must_be_filled)
                )
            }

            else -> {
                ValidationResult(
                    isSuccessful = true
                )
            }
        }
    }
}