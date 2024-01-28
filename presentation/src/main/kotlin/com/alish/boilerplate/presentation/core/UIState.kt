package com.alish.boilerplate.presentation.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.presentation.core.extensions.collectSafely
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * The [UIState] class represents the screen state in response to various actions,
 * such as requesting data, awaiting a response, handling errors, and successfully completing a request with data.
 *
 * @param T The type of data associated with the state.
 * @see [Either]
 */
sealed class UIState<T> {

    /**
     * [Idle] - The default state when there are no active data requests, and the screen has just been opened.
     */
    class Idle<T> : UIState<T>()

    /**
     * [Loading] - The state after sending a data request and waiting for a response.
     */
    class Loading<T> : UIState<T>()

    /**
     * [Error] - The state in case of an error occurring during a data request.
     *
     * @param error The network error associated with the current state.
     * @see NetworkError
     */
    class Error<T>(val error: NetworkError) : UIState<T>()

    /**
     * [Success] - The state when a data request is successful, and data is returned.
     *
     * @param data The data returned as a result of a successful request.
     */
    class Success<T>(val data: T) : UIState<T>()
}

/**
 * Creates a [MutableStateFlow] with [UIState] and the given initial value [UIState.Idle]
 */
@Suppress("FunctionName")
fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

/**
 * Reset [MutableUIStateFlow] to [UIState.Idle]
 */
fun <T> MutableStateFlow<UIState<T>>.reset() {
    this.value = UIState.Idle()
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