package com.alish.boilerplate.presentation.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.presentation.core.extensions.launchAndCollect
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
 * The [MutableUIStateFlow] is wrapper for [MutableStateFlow] with [UIState]
 *
 * @param T value type
 */
interface MutableUIStateFlow<T> : MutableStateFlow<UIState<T>> {

    /**
     * Reset [MutableUIStateFlow] to [UIState.Idle]
     */
    fun reset() {
        this.value = UIState.Idle()
    }
}

/**
 * Creates a [MutableStateFlow] with [UIState] and the given initial value [UIState.Idle]
 */
fun <T> BaseViewModel.MutableUIStateFlow(): MutableUIStateFlow<T> {
    return MutableStateFlow<UIState<T>>(UIState.Idle()) as MutableUIStateFlow<T>
}

/**
 * Collect [UIState] with [launchAndCollect]
 *
 * @receiver [StateFlow] with [UIState]
 *
 * @param state optional, for working with all states
 * @param onError for error handling
 * @param onSuccess for working with data
 */
inline fun <T> StateFlow<UIState<T>>.collectAsUIState(
    viewLifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    noinline state: ((UIState<T>) -> Unit)? = null,
    crossinline onError: ((error: NetworkError) -> Unit),
    crossinline onSuccess: ((data: T) -> Unit)
) {
    launchAndCollect(viewLifecycleOwner, lifecycleState) {
        state?.invoke(it)
        when (it) {
            is UIState.Idle -> {}
            is UIState.Loading -> {}
            is UIState.Error -> onError.invoke(it.error)
            is UIState.Success -> onSuccess.invoke(it.data)
        }
    }
}