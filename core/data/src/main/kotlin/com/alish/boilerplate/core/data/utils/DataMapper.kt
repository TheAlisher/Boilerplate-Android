package com.alish.boilerplate.core.data.utils

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
    fun asDomain(): T
}

/**
 * Base mapper interface from DTO to DBO
 *
 * @param T entity model
 *
 * @author Alish
 */
interface DatabaseMapper<T> {

    fun asDBO(): T
}