package com.alish.boilerplate.presentation.core.validation

interface Validator {
    operator fun invoke(text: String): ValidationResult
}