package com.alish.boilerplate.core.presentation.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * [AsynchronousExtensions] - only for docs and links
 *
 * Must read:
 * - [StateFlow and SharedFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
 * - [repeatOnLifecycle API design story](https://medium.com/androiddevelopers/repeatonlifecycle-api-design-story-8670d1a7d333)
 *
 * Useful links:
 * - [Reactive Streams](https://www.reactive-streams.org/)
 */
private class AsynchronousExtensions

/**
 * [launch] coroutine with [repeatOnLifecycle] API
 *
 * @param state [Lifecycle.State][Lifecycle.State] in which `block` runs in a new coroutine. That coroutine
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
 * [collect] flow safely with [launchWithRepeatOnLifecycle]
 */
inline fun <T> Flow<T>.launchAndCollectIn(
    viewLifecycleOwner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collector: suspend CoroutineScope.(T) -> Unit
) = viewLifecycleOwner.launchWithRepeatOnLifecycle(state) {
    collect { collector(it) }
}

/**
 * [collectLatest] flow safely with [launchWithRepeatOnLifecycle]
 */
inline fun <T> Flow<T>.launchAndCollectLatestIn(
    viewLifecycleOwner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collector: suspend CoroutineScope.(T) -> Unit
) = viewLifecycleOwner.launchWithRepeatOnLifecycle(state) {
    collectLatest { collector(it) }
}