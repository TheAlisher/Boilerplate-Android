package com.alish.boilerplate.data.utils

/**
 * Base mapper class
 *
 * @param T domain layer model
 */
interface DataMapper<T> {

    /**
     * Map DTO to domain layer model
     */
    fun mapToDomain(): T
}