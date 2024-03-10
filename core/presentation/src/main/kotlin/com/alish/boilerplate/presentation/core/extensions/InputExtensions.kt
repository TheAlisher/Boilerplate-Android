package com.alish.boilerplate.presentation.core.extensions

import android.util.Patterns
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.core.validators.ValidationResult
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Get text with [toString] & [trim] from Input
 */
val TextInputEditText.fullText: String get() = this.text.toString().trim()

/**
 * @receiver [ViewBinding]
 * @see [getChildInputLayouts]
 */
val ViewBinding.screenInputs get() = (this.root as ViewGroup).getChildInputLayouts()

/**
 * @receiver [ViewGroup]
 * @return [List] with [TextInputLayout] in fragments xml
 */
private fun ViewGroup.getChildInputLayouts(): List<TextInputLayout> {
    val inputs = mutableListOf<TextInputLayout>()
    for (i in 0 until childCount) {
        val childView = getChildAt(i)
        if (childView is TextInputLayout) {
            inputs.add(childView)
        }
        val childViewGroup = childView as? ViewGroup
        if (childViewGroup !is TextInputLayout) {
            childViewGroup?.getChildInputLayouts()
        }
    }
    return inputs
}

/**
 * Validates input fields associated with TextInputLayouts in a Fragment.
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * buttonSignIn.setOnClickListener {
 *     val emailResult = viewModel.validateEmail(
 *         inputEditSignInEmail.fullText
 *     )
 *     val passwordResult = viewModel.validatePassword(
 *         inputEditSignInPassword.fullText
 *     )
 *
 *     validateInputs(
 *         Pair(emailResult, inputLayoutSignInEmail),
 *         Pair(passwordResult, inputLayoutSignInPassword)
 *     ) {
 *         viewModel.signIn(
 *             inputEditSignInEmail.fullText,
 *             inputEditSignInPassword.fullText
 *         )
 *     }
 * }
 * ```
 *
 * @param pairInputAndValidationResult Vararg of pairs consisting of ValidationResult and TextInputLayout.
 *                                     Each pair represents an input field and its validation result.
 * @param successful A lambda function to be executed when all input fields pass validation.
 *
 */
fun Fragment.validateInputs(
    vararg pairInputAndValidationResult: Pair<ValidationResult, TextInputLayout>,
    successful: () -> Unit,
) {
    // Extract validation results from the pairs
    val validationResults = pairInputAndValidationResult.map { it.first }.toTypedArray()

    // Check if there are any validation errors
    if (hasError(*validationResults)) {
        // If there are errors, display error messages and enable error state for the associated TextInputLayouts
        pairInputAndValidationResult.map {
            if (it.first.isToast) {
                showToastShort(it.first.errorMessage)
            }
            it.second.error = it.first.errorMessage
        }
    } else {
        // If there are no errors, disable error state for the associated TextInputLayouts, hide keyboard, and execute the success callback
        pairInputAndValidationResult.map {
            it.second.isErrorEnabled = false
        }
        hideKeyboard()
        successful()
    }
}

/**
 * Checks if any of the validation results indicate an error.
 *
 * @param validationResults Array of ValidationResult objects to be checked for errors.
 * @return True if any ValidationResult in the array is unsuccessful (i.e., has an error), false otherwise.
 */
private fun hasError(vararg validationResults: ValidationResult) = validationResults.any {
    !it.isSuccessful
}

/** region Validators */
fun TextInputLayout.setupIsEmptyValidator() = with(editText as TextInputEditText) {
    setOnFocusChangeListener { _, hasFocus ->
        when {
            !hasFocus && text.toString().trim().isEmpty() -> {
                this@setupIsEmptyValidator.error = context.getString(R.string.field_must_be_filled)
            }

            hasFocus -> {
                this@setupIsEmptyValidator.isErrorEnabled = false
            }

            else -> {
                this@setupIsEmptyValidator.isErrorEnabled = false
            }
        }
    }
}

fun TextInputLayout.setupEmailValidator() = with(editText as TextInputEditText) {
    setOnFocusChangeListener { _, hasFocus ->
        when {
            !hasFocus && text.toString().trim().isEmpty() -> {
                this@setupEmailValidator.error = context.getString(R.string.field_must_be_filled)
            }

            !hasFocus && !Patterns.EMAIL_ADDRESS.matcher(text.toString().trim()).matches() -> {
                this@setupEmailValidator.error = context.getString(R.string.invalid_email)
            }

            hasFocus -> {
                this@setupEmailValidator.isErrorEnabled = false
            }

            else -> {
                this@setupEmailValidator.isErrorEnabled = false
            }
        }
    }
}

fun TextInputLayout.setupNameValidator() = with(editText as TextInputEditText) {
    setOnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) with(text.toString().trim()) {
            when {
                this.isEmpty() -> {
                    this@setupNameValidator.error = context.getString(
                        R.string.field_must_be_filled
                    )
                }

                this.matches(Regex(".*\\p{InCyrillic}.*")) -> {
                    this@setupNameValidator.error = context.getString(
                        R.string.write_in_latin
                    )
                }

                !this.matches(Regex("^[\\p{L} ]+$")) -> {
                    this@setupNameValidator.error = context.getString(
                        R.string.incorrect_name
                    )
                }

                this.length < 2 -> {
                    this@setupNameValidator.error = context.getString(
                        R.string.name_must_contain_at_least_2_characters
                    )
                }
            }
        } else {
            this@setupNameValidator.isHelperTextEnabled = false
            this@setupNameValidator.isErrorEnabled = false
        }
    }
}

fun TextInputLayout.setupPhoneValidator() = with(editText as TextInputEditText) {
    setOnFocusChangeListener { _, hasFocus ->
        when {
            !hasFocus && text.toString().trim().isEmpty() -> {
                this@setupPhoneValidator.error =
                    context.getString(R.string.field_must_be_filled)
            }

            !hasFocus && text.toString().length < 18 -> {
                this@setupPhoneValidator.error =
                    context.getString(R.string.complete_your_phone_number)
            }

            hasFocus -> {
                this@setupPhoneValidator.isErrorEnabled = false
            }

            else -> {
                this@setupPhoneValidator.isErrorEnabled = false
            }
        }
    }
}

fun TextInputLayout.setupPasswordValidator() = with(editText as TextInputEditText) {
    setOnFocusChangeListener { _, hasFocus ->
        when {
            !hasFocus && text.toString().trim().isEmpty() -> {
                this@setupPasswordValidator.error = context.getString(R.string.field_must_be_filled)
            }

            !hasFocus && text.toString().trim().length < 6 -> {
                this@setupPasswordValidator.error = context.getString(
                    R.string.password_must_not_be_less_than_6_characters
                )
            }

            hasFocus -> {
                this@setupPasswordValidator.isErrorEnabled = false
            }

            else -> {
                this@setupPasswordValidator.isErrorEnabled = false
            }
        }
    }
}
// endregion