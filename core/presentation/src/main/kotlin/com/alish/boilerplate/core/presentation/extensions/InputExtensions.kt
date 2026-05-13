package com.alish.boilerplate.core.presentation.extensions

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alish.boilerplate.core.presentation.validation.Validator
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * Get text with [toString] & [trim] from Input
 */
val TextInputEditText.fullText: String get() = this.text.toString().trim()

/**
 * Collects all [TextInputLayout] inside this [ViewGroup] (DFS traversal).
 *
 * @param out destination list to append found inputs.
 */
fun ViewGroup.collectInputLayouts(out: MutableList<TextInputLayout>) {
    for (i in 0 until childCount) {
        val childView = getChildAt(i)

        if (childView is TextInputLayout) {
            out.add(childView)
        } else if (childView is ViewGroup) {
            childView.collectInputLayouts(out)
        }
    }
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
 *         viewModel.validateEmail to inputLayoutSignInEmail,
 *         viewModel.validatePassword to inputLayoutSignInPassword
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
    onSuccess: () -> Unit
) {
    val validatorResults = validatorWithInput.map { (validator, inputLayout) ->
        val text = (inputLayout.editText as TextInputEditText).fullText
        validator(text) to inputLayout
    }

    val hasErrors = validatorResults.any { (result, _) -> !result.isSuccessful }

    if (hasErrors) {
        validatorResults.forEach { (result, inputLayout) ->
            if (result.isToast) {
                showToastShort(result.errorMessage)
            } else {
                inputLayout.error = result.errorMessage
            }
        }
    } else {
        validatorResults.forEach { (_, inputLayout) -> inputLayout.isErrorEnabled = false }
        hideKeyboard()
        onSuccess()
    }
}