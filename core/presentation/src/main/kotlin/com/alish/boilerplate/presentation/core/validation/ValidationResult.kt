package com.alish.boilerplate.presentation.core.validation

class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: String = "",
    val isToast: Boolean = false,
)