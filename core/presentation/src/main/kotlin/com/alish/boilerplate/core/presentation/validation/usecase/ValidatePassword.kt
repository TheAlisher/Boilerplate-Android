package com.alish.boilerplate.core.presentation.validation.usecase

import android.content.Context
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.core.presentation.validation.ValidationResult
import com.alish.boilerplate.core.presentation.validation.Validator
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ValidatePassword @Inject constructor(
    @param:ApplicationContext private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult = when {
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