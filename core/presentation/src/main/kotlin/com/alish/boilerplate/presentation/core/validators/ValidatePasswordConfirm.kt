package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidatePasswordConfirm @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(password: String, confirmPassword: String): ValidationResult {
        return when {
            password.isEmpty() && confirmPassword.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.field_must_be_filled)
                )
            }

            password != confirmPassword -> {
                ValidationResult(
                    isSuccessful = false,
                    errorMessage = context.getString(R.string.password_do_not_match),
                    isToast = true
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