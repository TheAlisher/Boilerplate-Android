package com.alish.boilerplate.presentation.ui.fragments.foo

import com.alish.boilerplate.presentation.base.BaseViewModel
import com.alish.boilerplate.domain.usecases.foo.FetchFooUseCase
import com.alish.boilerplate.presentation.models.FooUI
import com.alish.boilerplate.presentation.models.toUI
import com.alish.boilerplate.presentation.ui.state.MutableUIStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectRequest(_fooState) { it.toUI() }
    }
}