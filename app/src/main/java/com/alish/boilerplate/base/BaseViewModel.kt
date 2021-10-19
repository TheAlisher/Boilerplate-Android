package com.alish.boilerplate.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.common.resource.Resource
import com.alish.boilerplate.presentation.state.StateViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> subscribeTo(
        state: StateViewModel<T>,
        request: () -> Flow<Resource<T>>
    ) {
        viewModelScope.launch {
            request().collect {
                state.isLoading.value = it is Resource.Loading
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Error -> {
                        it.message?.let { error ->
                            state.error.value = error
                        }
                    }
                    is Resource.Success -> {
                        it.data?.let { data ->
                            state.data.value = data
                        }
                    }
                }
            }
        }
    }
}