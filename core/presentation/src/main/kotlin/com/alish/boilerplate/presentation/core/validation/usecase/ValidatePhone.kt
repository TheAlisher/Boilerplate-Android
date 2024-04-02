package com.alish.boilerplate.presentation.core.validation.usecase

import android.content.Context
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.core.validation.ValidationResult
import com.alish.boilerplate.presentation.core.validation.Validator
import javax.inject.Inject

class ValidatePhone @Inject constructor(
    private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult = when {
        text.isEmpty() -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.field_must_be_filled)
            )
        }

        text.length < 18 -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.complete_your_phone_number)
            )
        }

        else -> {
            ValidationResult(
                isSuccessful = true,
            )
        }
    }
}