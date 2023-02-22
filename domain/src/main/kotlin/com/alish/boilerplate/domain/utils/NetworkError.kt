package com.alish.boilerplate.domain.utils

/**
 * Network error wrapper class
 *
 * @author Alish
 */
sealed class NetworkError {

    /**
     * Unexpected error for example 500 or exception when mapping data
     */
    class Unexpected(val error: String) : NetworkError()

    /**
     * Default errors from server side
     */
    class Api(val error: String) : NetworkError()

    /**
     * Errors for display in inputs
     *
     * @param error
     * Map [Key][kotlin.collections.Map.Entry.key] is input name,
     * Map [Value][kotlin.collections.Map.Entry.value] is errors from server side
     */
    class ApiInputs(val error: MutableMap<String, List<String>>) : NetworkError()
}