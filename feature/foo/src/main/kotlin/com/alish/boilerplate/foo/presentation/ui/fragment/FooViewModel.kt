package com.alish.boilerplate.foo.presentation.ui.fragment

import com.alish.boilerplate.foo.domain.usecase.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.foo.domain.usecase.FetchFooUseCase
import com.alish.boilerplate.foo.domain.usecase.GetFooListUseCase
import com.alish.boilerplate.presentation.core.MutableUIStateFlow
import com.alish.boilerplate.foo.presentation.model.FooUI
import com.alish.boilerplate.foo.presentation.model.toUI
import com.alish.boilerplate.presentation.core.extensions.mapList
import com.alish.boilerplate.presentation.core.extensions.mapPaging
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
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.toUI() }
    }

    fun getFooList() = getFooListUseCase().mapList { it.toUI() }

    val fooPaging = fetchFooPagingUseCase().mapPaging(this) { it.toUI() }
}