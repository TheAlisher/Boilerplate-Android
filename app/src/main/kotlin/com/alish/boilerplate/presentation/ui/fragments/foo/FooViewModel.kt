package com.alish.boilerplate.presentation.ui.fragments.foo

import com.alish.boilerplate.domain.models.foo.Foo
import com.alish.boilerplate.presentation.base.BaseViewModel
import com.alish.boilerplate.domain.usecases.foo.FetchFooUseCase
import com.alish.boilerplate.domain.usecases.foo.GetFooUseCase
import com.alish.boilerplate.presentation.models.foo.FooUI
import com.alish.boilerplate.presentation.models.foo.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val getFooUseCase: GetFooUseCase
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.toUI() }
    }

    fun getFoo() = getFooUseCase().collectLocalRequest { it.toUI() }
}