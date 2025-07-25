package com.alish.boilerplate.core.domain

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
     * State for displaying errors in input fields
     *
     * @param errors
     * Map [Key][Map.Entry.key] is input name,
     * Map [Value][Map.Entry.value] is errors from server side
     */
    class ApiInputs(val errors: MutableMap<String, List<String>>) : NetworkError()

    /**
     * State for default errors from server size
     */
    class Api(val message: String) : NetworkError()

    /**
     * State for unexpected exceptions, for example «HTTP code - 500» or exceptions when mapping models
     */
    class Unexpected(val message: String) : NetworkError()
}