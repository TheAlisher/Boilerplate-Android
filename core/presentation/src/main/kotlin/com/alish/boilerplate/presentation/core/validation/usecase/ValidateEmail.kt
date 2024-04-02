package com.alish.boilerplate.presentation.core.validation.usecase

import android.content.Context
import android.util.Patterns
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.core.validation.ValidationResult
import com.alish.boilerplate.presentation.core.validation.Validator
import javax.inject.Inject

class ValidateEmail @Inject constructor(
    private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult = when {
        text.isEmpty() -> {
            ValidationResult(
                isSuccessful = false,
                errorMessage = context.getString(R.string.field_must_be_filled)
            )
        }

        !Patterns.EMAIL_ADDRESS.matcher(text).matches() -> {
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