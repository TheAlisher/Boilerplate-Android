package com.alish.boilerplate.presentation.core.validators

interface Validator {
    operator fun invoke(text: String): ValidationResult
}