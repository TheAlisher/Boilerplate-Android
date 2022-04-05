package com.alish.boilerplate.domain

sealed class Either<out R> {
    class Left(val error: String) : Either<Nothing>()
    class Right<out T>(val data: T) : Either<T>()
}