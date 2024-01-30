package com.alish.boilerplate.domain.core

/**
 * Wrapper class for network errors
 *
 * @author Alish
 */
sealed class NetworkError {

    /**
     * State for Timeout exceptions
     */
    data object Timeout : NetworkError()

    /**
     * State for unexpected exceptions, for example «HTTP code - 500» or exceptions when mapping models
     */
    class Unexpected(val errorMessage: String) : NetworkError()

    /**
     * State for default errors from server size
     */
    class Api(val errorMessage: String?) : NetworkError()

    /**
     * State for displaying errors in input fields
     *
     * @param inputErrors
     * Map [Key][kotlin.collections.Map.Entry.key] is input name,
     * Map [Value][kotlin.collections.Map.Entry.value] is errors from server side
     */
    class ApiInputs(val inputErrors: MutableMap<String, List<String>>?) : NetworkError()
}