package com.alish.boilerplate.core.presentation.validation.usecase

import android.content.Context
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.core.presentation.validation.ValidationResult
import com.alish.boilerplate.core.presentation.validation.Validator
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ValidateName @Inject constructor(
    @param:ApplicationContext private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult = when {
        text.isEmpty() -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.field_must_be_filled)
            )
        }

        text.matches(Regex(".*\\p{InCyrillic}.*")) -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.write_in_latin)
            )
        }

        !text.matches(Regex("^[\\p{L} ]+$")) -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.incorrect_name)
            )
        }

        text.length < 2 -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.name_must_contain_at_least_2_characters)
            )
        }

        else -> {
            ValidationResult(
                isSuccessful = true,
            )
        }
    }
}