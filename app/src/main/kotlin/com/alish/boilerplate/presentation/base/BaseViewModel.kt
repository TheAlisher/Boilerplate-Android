package com.alish.boilerplate.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.alish.boilerplate.domain.utils.Either
import com.alish.boilerplate.domain.utils.NetworkError
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
     * Collect network request result without mapping
     *
     * @receiver [NetworkError] or [T] in [Flow] with [Either]
     *
     * @param T domain layer model
     * @param state [MutableStateFlow] with [UIState] depending request result
     *
     * @see viewModelScope
     * @see launch
     * @see [Flow.collect]
     */
    protected fun <T> Flow<Either<NetworkError, T>>.collectRequest(
        state: MutableStateFlow<UIState<T>>,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(it.value)
                }
            }
        }
    }

    /**
     * Collect network request result with mapping
     *
     * @receiver [NetworkError] or [T] in [Flow] with [Either]
     *
     * @param T domain layer model
     * @param S presentation layer model
     * @param state [MutableStateFlow] with [UIState] depending request result
     * @param mapToUI high-order function for setup mapper function
     *
     * @see viewModelScope
     * @see launch
     * @see [Flow.collect]
     */
    protected fun <T, S> Flow<Either<NetworkError, T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mapToUI: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mapToUI(it.value))
                }
            }
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
        value.map { data: T -> mapToUI(data) }
    }.cachedIn(viewModelScope)
}