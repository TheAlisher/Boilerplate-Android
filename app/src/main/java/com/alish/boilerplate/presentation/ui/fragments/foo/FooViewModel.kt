package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alish.boilerplate.common.base.BaseViewModel
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.usecases.foo.FetchFooUseCase
import com.alish.boilerplate.presentation.models.FooUI
import com.alish.boilerplate.presentation.models.toFooUI
import com.alish.boilerplate.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    private val _fooState = MutableLiveData<UIState<FooUI>>()
    val fooState: LiveData<UIState<FooUI>> = _fooState

    fun fetchFoo() {
        _fooState.subscribeTo({ fetchFooUseCase() }, { it.toFooUI() })
    }

    fun fetchFooPaging() = repository.fetchFooPaging()
        .mapPaging { it.toFooUI() }
        .cachedIn(viewModelScope)
}