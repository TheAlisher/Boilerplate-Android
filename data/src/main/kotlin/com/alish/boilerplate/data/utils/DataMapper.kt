package com.alish.boilerplate.data.utils

/**
 * Base mapper interface
 *
 * @param T domain layer model
 *
 * @author Alish
 */
interface DataMapper<T> {

    /**
     * Function for map data layer model to domain layer model
     */
    fun mapToDomain(): T
}