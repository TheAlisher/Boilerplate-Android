package com.alish.boilerplate.presentation.core.validators

class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: String = "",
    val isToast: Boolean = false,
)