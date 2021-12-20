package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alish.boilerplate.common.base.BaseViewModel
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.usecases.foo.FetchFooUseCase
import com.alish.boilerplate.presentation.models.FooUI
import com.alish.boilerplate.presentation.models.toUI
import com.alish.boilerplate.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    private val _fooState = MutableStateFlow<UIState<FooUI>>(UIState.Loading())
    val fooState: StateFlow<UIState<FooUI>> = _fooState

    fun fetchFoo() {
        _fooState.subscribeTo({ fetchFooUseCase() }, { it.toUI() })
    }

    fun fetchFooPaging() = repository.fetchFooPaging()
        .mapPaging { it.toUI() }
        .cachedIn(viewModelScope)
}