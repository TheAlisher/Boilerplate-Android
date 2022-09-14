package com.alish.boilerplate.data.utils

interface DataMapper<T> {
    fun mapToDomain(): T
}