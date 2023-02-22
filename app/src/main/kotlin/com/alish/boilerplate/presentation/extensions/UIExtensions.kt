package com.alish.boilerplate.presentation.extensions

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


// region Fragment extensions

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastShort(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastShort(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_SHORT).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastLong(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

/**
 * Fast show [Toast]
 *
 * @receiver [Fragment]
 */
fun Fragment.showToastLong(@StringRes textFromRes: Int) {
    Toast.makeText(context, textFromRes, Toast.LENGTH_LONG).show()
}

/**
 * Hide keyboard extension function
 *
 * @receiver [Fragment]
 */
fun Fragment.hideKeyboard() {
    val inputMethodManager = requireActivity().getSystemService(
        Activity.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(requireView().windowToken, 0)
}

// endregion