package com.alish.boilerplate.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.alish.boilerplate.common.resource.Resource
import com.alish.boilerplate.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <TDomain, T> MutableStateFlow<UIState<T>>.subscribeTo(
        request: () -> Flow<Resource<TDomain>>,
        mappedData: (TDomain) -> T
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            request().collect {
                when (it) {
                    is Resource.Loading -> {
                        this@subscribeTo.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        this@subscribeTo.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        this@subscribeTo.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }

    protected fun <ValueDomain : Any, ValueUI : Any> Flow<PagingData<ValueDomain>>.mapPaging(
        mappedData: (ValueDomain) -> ValueUI
    ) = this.map { data -> data.map { mappedData(it) } }
}