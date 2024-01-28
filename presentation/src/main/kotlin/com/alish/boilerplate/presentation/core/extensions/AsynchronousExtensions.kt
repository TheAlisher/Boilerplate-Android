package com.alish.boilerplate.presentation.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Launch coroutine with [repeatOnLifecycle] API
 *
 * @param state [Lifecycle.State][androidx.lifecycle.Lifecycle.State] in which `block` runs in a new coroutine. That coroutine
 * will cancel if the lifecycle falls below that state, and will restart if it's in that state
 * again.
 * @param block The block to run when the lifecycle is at least in [state] state.
 */
internal fun LifecycleOwner.launchRepeatOnLifecycle(
    state: Lifecycle.State,
    block: suspend CoroutineScope.() -> Unit,
) {
    this.lifecycleScope.launch {
        this@launchRepeatOnLifecycle.repeatOnLifecycle(state, block)
    }
}

/**
 * Collect flow safely with [launchRepeatOnLifecycle]
 */
fun <T> Flow<T>.collectSafely(
    viewLifecycleOwner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    collector: (T) -> Unit,
) {
    viewLifecycleOwner.launchRepeatOnLifecycle(state) {
        this@collectSafely.collect {
            collector(it)
        }
    }
}