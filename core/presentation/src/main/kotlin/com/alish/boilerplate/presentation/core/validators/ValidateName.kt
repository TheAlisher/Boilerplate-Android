package com.alish.boilerplate.presentation.core.validators

import android.content.Context
import com.alish.boilerplate.presentation.R
import javax.inject.Inject

class ValidateName @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(name: String): ValidationResult {
        return when {
            name.isEmpty() -> {
                ValidationResult(
                    isSuccessful = false,
                    context.getString(R.string.field_must_be_filled)
                )
            }

            /*
            name.matches(Regex(".*\\p{InCyrillic}.*")) -> {
                ValidationResult(
                    isSuccessful = false,
                    context.getString(R.string.write_in_latin)
                )
            }
            */

            !name.matches(Regex("^[\\p{L} ]+$")) -> {
                ValidationResult(
                    isSuccessful = false,
                    context.getString(R.string.incorrect_name)
                )
            }

            name.length < 2 -> {
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
}