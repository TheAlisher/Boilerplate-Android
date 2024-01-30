package com.alish.boilerplate.presentation.ui

import com.alish.boilerplate.domain.usecases.FetchFooUseCase
import com.alish.boilerplate.domain.usecases.GetFooUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.presentation.models.FooUI
import com.alish.boilerplate.presentation.models.toUI
import com.alish.boilerplate.presentation.core.MutableUIStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val getFooUseCase: GetFooUseCase,
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.toUI() }
    }

    fun getFoo() = getFooUseCase().collectLocalRequestForList { it.toUI() }
}