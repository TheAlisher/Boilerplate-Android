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
     * Creates [MutableStateFlow] with [UIState] and the given initial value [UIState.Idle]
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
     * Collect network request
     *
     * @return [UIState] depending request result
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
     * Collect network request with mapping from domain to ui
     *
     * @return [UIState] depending request result
     */
    protected fun <T, S> Flow<Either<NetworkError, T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mappedData(it.value))
                }
            }
        }
    }

    /**
     * Collect paging request
     */
    protected fun <T : Any, S : Any> Flow<PagingData<T>>.collectPagingRequest(
        mappedData: (T) -> S
    ) = map { it.map { data -> mappedData(data) } }.cachedIn(viewModelScope)
}