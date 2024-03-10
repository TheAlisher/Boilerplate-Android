package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import android.util.Patterns
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidateEmail @Inject constructor(
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

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.invalid_email)
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