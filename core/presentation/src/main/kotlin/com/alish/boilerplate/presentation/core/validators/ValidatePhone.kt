package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidatePhone @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(phone: String): ValidationResult {
        return when {
            phone.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    context.getString(R.string.field_must_be_filled)
                )
            }

            phone.length < 18 -> {
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
}