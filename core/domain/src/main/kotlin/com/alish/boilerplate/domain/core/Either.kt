package com.alish.boilerplate.domain.core

/**
 * Either is used to short-circuit a computation upon the first error.
 *
 * By convention, the right side of an Either is used to hold successful values.
 *
 * &nbsp
 *
 * [*from arrow-core*](https://apidocs.arrow-kt.io/arrow-core/arrow.core/-either/)
 *
 * @see Nothing
 */
sealed class Either<out A, out B> {

    /**
     * The left side of the disjoint union, as opposed to the [Right] side.
     */
    class Left<out A>(val value: A) : Either<A, Nothing>()

    /**
     * The right side of the disjoint union, as opposed to the [Left] side.
     */
    class Right<out B>(val value: B) : Either<Nothing, B>()
}