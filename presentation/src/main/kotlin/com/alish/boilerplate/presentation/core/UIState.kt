package com.alish.boilerplate.presentation.core

import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.domain.core.Either

/**
 * Base state for fragments
 *
 * @see [Either]
 */
sealed class UIState<T> {

    /**
     * State when open fragment
     */
    class Idle<T> : UIState<T>()

    /**
     * State when we do request and show loader
     */
    class Loading<T> : UIState<T>()

    /**
     * State if request return error
     */
    class Error<T>(val error: NetworkError) : UIState<T>()

    /**
     * State if request is success and return data
     */
    class Success<T>(val data: T) : UIState<T>()
}