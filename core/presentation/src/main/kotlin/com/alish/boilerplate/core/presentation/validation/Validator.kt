package com.alish.boilerplate.core.presentation.validation

interface Validator {
    operator fun invoke(text: String): ValidationResult
}