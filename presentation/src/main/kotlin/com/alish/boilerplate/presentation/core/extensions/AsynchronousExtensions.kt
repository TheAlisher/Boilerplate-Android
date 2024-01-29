package com.alish.boilerplate.presentation.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.presentation.core.UIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * [AsynchronousExtensions] - only for docs and links
 *
 * Must read:
 * [repeatOnLifecycle API design story](https://medium.com/androiddevelopers/repeatonlifecycle-api-design-story-8670d1a7d333)
 */
private class AsynchronousExtensions

/**
 * [launch] coroutine with [repeatOnLifecycle] API
 *
 * @param state [Lifecycle.State][androidx.lifecycle.Lifecycle.State] in which `block` runs in a new coroutine. That coroutine
 * will cancel if the lifecycle falls below that state, and will restart if it's in that state
 * again.
 * @param block The block to run when the lifecycle is at least in [state] state.
 */
inline fun LifecycleOwner.launchWithRepeatOnLifecycle(
    state: Lifecycle.State,
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(state) {
            block()
        }
    }
}

/**
 * Collect flow safely with [launchWithRepeatOnLifecycle]
 */
inline fun <T> Flow<T>.launchAndCollect(
    viewLifecycleOwner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collector: suspend CoroutineScope.(T) -> Unit
) = viewLifecycleOwner.launchWithRepeatOnLifecycle(state) {
    collect { collector(it) }
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