package com.alish.boilerplate.presentation.ui.state

import kotlinx.coroutines.flow.MutableStateFlow

interface MutableUIStateFlow<T> : MutableStateFlow<UIState<T>> {

    /**
     * Reset [UIState]
     */
    fun setIdle() {
        value = UIState.Idle()
    }
}

/**
 * Creates [MutableStateFlow] with [UIState] and the given initial value [UIState.Idle]
 */
@Suppress("FunctionName")
fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle()) as MutableUIStateFlow<T>

