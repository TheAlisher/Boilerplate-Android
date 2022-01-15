package com.alish.boilerplate.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.alish.boilerplate.common.resource.Resource
import com.alish.boilerplate.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T, S> Flow<Resource<T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectRequest.collect {
                when (it) {
                    is Resource.Loading -> {
                        state.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        state.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        state.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }

    protected fun <ValueDomain : Any, ValueUI : Any> Flow<PagingData<ValueDomain>>.mapPaging(
        mappedData: (ValueDomain) -> ValueUI
    ) = this.map { data -> data.map { mappedData(it) } }
}