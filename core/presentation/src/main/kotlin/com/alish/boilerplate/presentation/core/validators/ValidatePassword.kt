package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidatePassword @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(password: String): ValidationResult {
        return when {
            password.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.field_must_be_filled),
                )
            }

            password.length < 6 -> {
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