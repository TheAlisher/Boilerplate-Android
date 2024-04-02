package com.alish.boilerplate.presentation.core.extensions

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.presentation.core.validation.ValidationResult
import com.alish.boilerplate.presentation.core.validation.Validator
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
 * Validates input fields within a Fragment using provided validators.
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * buttonSignIn.setOnClickListener {
 *     validateInputs(
 *         Pair(viewModel.validateEmail, inputLayoutSignInEmail),
 *         Pair(viewModel.validatePassword, inputLayoutSignInPassword)
 *     ) {
 *         viewModel.signIn(
 *             inputEditSignInEmail.fullText,
 *             inputEditSignInPassword.fullText
 *         )
 *     }
 * }
 * ```
 *
 * @param validatorWithInput a vararg list of pairs, each containing a Validator and a TextInputLayout.
 * @param successful a function to be executed when validation succeeds.
 */
fun Fragment.validateInputs(
    vararg validatorWithInput: Pair<Validator, TextInputLayout>,
    successful: () -> Unit,
) {
    // Perform validation for each validator-input pair
    val validationResultsPair = validatorWithInput.map {
        val validator = it.first
        val inputLayout = it.second
        val inputEdit = (inputLayout.editText as TextInputEditText)

        Pair(validator.invoke(inputEdit.fullText), inputLayout)
    }

    // Extract validation results
    val validationResults = validationResultsPair.map {
        it.first
    }.toTypedArray()

    // Check if any validation result indicates error
    if (hasError(*validationResults)) {
        // Handle error for each input layout
        validationResultsPair.map {
            val validationResult = it.first
            val inputLayout = it.second
            if (validationResult.isToast) {
                showToastShort(validationResult.errorMessage)
            }
            inputLayout.error = validationResult.errorMessage
        }
    } else {
        // If no error, clear errors and execute success function
        validationResultsPair.map {
            it.second.isErrorEnabled = false
        }
        hideKeyboard()
        successful()
    }
}

/**
 * Checks if any ValidationResult indicates an error.
 *
 * @param validationResults a vararg list of ValidationResult objects.
 * @return true if any ValidationResult indicates an error, false otherwise.
 */
private fun hasError(vararg validationResults: ValidationResult) = validationResults.any {
    !it.isSuccessful
}