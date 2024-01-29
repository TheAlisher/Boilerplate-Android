package com.alish.boilerplate.presentation.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
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
inline fun LifecycleOwner.launchAndRepeatOnLifecycle(
    state: Lifecycle.State,
    crossinline block: suspend CoroutineScope.() -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(state) {
            block()
        }
    }
}

/**
 * Collect flow safely with [launchAndRepeatOnLifecycle]
 */
inline fun <T> Flow<T>.collectSafely(
    viewLifecycleOwner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collector: suspend CoroutineScope.(T) -> Unit,
) = viewLifecycleOwner.launchAndRepeatOnLifecycle(state) {
    collect { collector(it) }
}