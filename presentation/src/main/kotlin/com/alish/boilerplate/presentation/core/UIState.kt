package com.alish.boilerplate.presentation.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.presentation.core.extensions.collectSafely
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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

/**
 * Collect [UIState] with [collectSafely]
 *
 * @receiver [StateFlow] with [UIState]
 *
 * @param state optional, for working with all states
 * @param onError for error handling
 * @param onSuccess for working with data
 */
fun <T> StateFlow<UIState<T>>.collectUIState(
    viewLifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    state: ((UIState<T>) -> Unit)? = null,
    onError: ((error: NetworkError) -> Unit),
    onSuccess: ((data: T) -> Unit)
) {
    this.collectSafely(viewLifecycleOwner, lifecycleState) {
        state?.invoke(it)
        when (it) {
            is UIState.Idle -> {}
            is UIState.Loading -> {}
            is UIState.Error -> onError.invoke(it.error)
            is UIState.Success -> onSuccess.invoke(it.data)
        }
    }
}