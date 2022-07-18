package com.alish.boilerplate.presentation.ui.state

import com.alish.boilerplate.domain.utils.NetworkError

sealed class UIState<T> {
    class Idle<T> : UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val errors: NetworkError) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}