package com.alish.boilerplate.presentation.core.validation.usecase

import android.content.Context
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.core.validation.ValidationResult
import com.alish.boilerplate.presentation.core.validation.Validator
import javax.inject.Inject

class ValidatePassword @Inject constructor(
    private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult {
        return when {
            text.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.field_must_be_filled),
                )
            }

            text.length < 6 -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.password_must_not_be_less_than_6_characters)
                )
            }

            else -> {
                ValidationResult(
                    isSuccessful = true,
                )
            }
        }
    }
}