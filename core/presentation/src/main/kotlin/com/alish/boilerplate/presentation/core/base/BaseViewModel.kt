package com.alish.boilerplate.presentation.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.domain.core.Either
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.presentation.core.UIState
import com.alish.boilerplate.presentation.core.reset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Base class for all [ViewModel]s
 *
 * @author Alish
 */
abstract class BaseViewModel : ViewModel() {

    /**
     * Collect network request result without mapping for primitive types
     *
     * @receiver [collectEither]
     */
    protected fun <T> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<T>>,
        resetStateAfterCollect: Boolean = false
    ) = collectEither(state, resetStateAfterCollect) {
        UIState.Success(it)
    }

    /**
     * Collect network request result with mapping
     *
     * @receiver [collectEither]
     */
    protected fun <T, S> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<S>>,
        resetStateAfterCollect: Boolean = false,
        mapToUI: (T) -> S
    ) = collectEither(state, resetStateAfterCollect) {
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
        resetStateAfterCollect: Boolean,
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
            if (resetStateAfterCollect) {
                state.reset()
            }
        }
    }
}