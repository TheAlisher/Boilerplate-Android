package com.alish.boilerplate.domain.utils

/**
 * Either is used to short-circuit a computation upon the first error.
 *
 * By convention, the right side of an Either is used to hold successful values.
 */
sealed class Either<out A, out B> {
    class Left<out A>(val value: A) : Either<A, Nothing>()
    class Right<out B>(val value: B) : Either<Nothing, B>()
}