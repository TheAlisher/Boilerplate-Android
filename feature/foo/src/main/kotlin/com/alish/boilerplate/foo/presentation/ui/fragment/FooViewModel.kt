package com.alish.boilerplate.foo.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.core.domain.mapList
import com.alish.boilerplate.core.domain.mapPaging
import com.alish.boilerplate.foo.domain.usecase.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.foo.domain.usecase.FetchFooUseCase
import com.alish.boilerplate.foo.domain.usecase.GetFooListUseCase
import com.alish.boilerplate.presentation.core.MutableUIStateFlow
import com.alish.boilerplate.foo.presentation.model.FooUI
import com.alish.boilerplate.foo.presentation.model.asUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val getFooListUseCase: GetFooListUseCase,
    fetchFooPagingUseCase: FetchFooPagingUseCase
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.asUI() }
    }

    fun getFooList() = getFooListUseCase().mapList { it.asUI() }

    val fooPaging = fetchFooPagingUseCase().mapPaging(viewModelScope) { it.asUI() }
}