package com.alish.boilerplate.presentation.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
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

/**
 * Transforms each element in a [list][List] emitted by a [Flow] using the provided [transform] function.
 *
 * This function is an inline extension for a [Flow] that emits a [list][List] of elements of type [T].
 * It applies the [transform] function to each element in the list and returns a Flow
 * that emits a list of transformed elements of type [R].
 *
 * @param T the type of the elements in the original list.
 * @param R the type of the elements in the transformed list.
 * @param transform a function that takes an element of type [T] and returns an element of type [R].
 * @return a [Flow] that emits [list][List] of transformed elements of type [R].
 */
inline fun <T, R> Flow<List<T>>.mapList(
    crossinline transform: (value: T) -> R
): Flow<List<R>> = this.map { list -> list.map(transform) }

/**
 * Transforms each element in a [PagingData] stream emitted by a [Flow] using the provided [transform] function,
 * and caches the resulting [Flow] within the [viewModel]'s scope.
 *
 * This function is an inline extension for a [Flow] that emits [PagingData] containing elements of type [T].
 * It applies the [transform] function to each element within the [PagingData] and returns a [Flow]
 * that emits [PagingData] containing elements of type [R]. Additionally, the resulting [Flow] is cached
 * in the [viewModel]'s [viewModelScope].
 *
 * @param T the type of the elements in the original [PagingData].
 * @param R the type of the elements in the transformed [PagingData].
 * @param viewModel the [BaseViewModel] that provides the scope to cache the [Flow].
 * @param transform a function that takes an element of type [T] and returns an element of type [R].
 * @return a [Flow] that emits transformed [PagingData] containing elements of type [R], cached in the [viewModel]'s scope.
 */
inline fun <T : Any, R : Any> Flow<PagingData<T>>.mapPaging(
    viewModel: BaseViewModel,
    crossinline transform: (value: T) -> R
): Flow<PagingData<R>> = this.map { value: PagingData<T> ->
    value.map {
        it.let(transform)
    }
}.cachedIn(viewModel.viewModelScope)
