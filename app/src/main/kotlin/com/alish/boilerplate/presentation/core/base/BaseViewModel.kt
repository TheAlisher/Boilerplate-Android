package com.alish.boilerplate.presentation.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.presentation.ui.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * Base class for all [ViewModel]s
 *
 * @author Alish
 */
abstract class BaseViewModel : ViewModel() {

    /**
     * Creates a [MutableStateFlow] with [UIState] and the given initial value [UIState.Idle]
     */
    @Suppress("FunctionName")
    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    /**
     * Reset [MutableUIStateFlow] to [UIState.Idle]
     */
    protected fun <T> MutableStateFlow<UIState<T>>.reset() {
        value = UIState.Idle()
    }

    /**
     * Collect network request result without mapping for primitive types
     *
     * @receiver [collectEither]
     */
    protected fun <T> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<T>>
    ) = collectEither(state) {
        UIState.Success(it)
    }

    /**
     * Collect network request result with mapping
     *
     * @receiver [collectEither]
     */
    protected fun <T, S> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<S>>,
        mapToUI: (T) -> S
    ) = collectEither(state) {
        UIState.Success(mapToUI(it))
    }

    /**
     * Collect network request result and mapping [Either] to [UIState]
     *
     * @receiver [NetworkError] or [data][T] in [Flow] with [Either]
     *
     * @param T domain layer model
     * @param S presentation layer model
     * @param state [MutableStateFlow] with [UIState]
     *
     * @see viewModelScope
     * @see launch
     * @see [Flow.collect]
     */
    private fun <T, S> Flow<Either<NetworkError, T>>.collectEither(
        state: MutableStateFlow<UIState<S>>,
        successful: (T) -> UIState.Success<S>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectEither.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = successful(it.value)
                }
            }
        }
    }

    /**
     * Collect local request to database with mapping
     *
     * @receiver [T] with [Flow]
     *
     * @param T domain layer model
     * @param S presentation layer model
     * @param mapToUI high-order function for setup mapper functions
     */
    protected fun <T, S> Flow<T>.collectLocalRequest(
        mapToUI: (T) -> S
    ): Flow<S> = map { value: T ->
        mapToUI(value)
    }

    /**
     * Collect local request to database with mapping with [List]
     *
     * @receiver [T] in [List] with [Flow]
     *
     * @param T domain layer model
     * @param S presentation layer model
     * @param mapToUI high-order function for setup mapper functions
     */
    protected fun <T, S> Flow<List<T>>.collectLocalRequestForList(
        mapToUI: (T) -> S
    ): Flow<List<S>> = map { value: List<T> ->
        value.map { data: T ->
            mapToUI(data)
        }
    }

    /**
     * Collect paging request with mapping
     *
     * @receiver [PagingData] with [T] in [Flow]
     *
     * @param T domain layer model
     * @param S presentation layer model
     * @param mapToUI high-order function for setup mapper function
     *
     * @see cachedIn
     * @see viewModelScope
     */
    protected fun <T : Any, S : Any> Flow<PagingData<T>>.collectPagingRequest(
        mapToUI: (T) -> S
    ): Flow<PagingData<S>> = map { value: PagingData<T> ->
        value.map { data: T ->
            mapToUI(data)
        }
    }.cachedIn(viewModelScope)
}