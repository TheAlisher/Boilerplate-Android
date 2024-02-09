package com.alish.boilerplate.foo.presentation.ui.fragments.foo

import com.alish.boilerplate.foo.domain.usecases.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.foo.domain.usecases.FetchFooUseCase
import com.alish.boilerplate.foo.domain.usecases.GetFooUseCase
import com.alish.boilerplate.presentation.core.MutableUIStateFlow
import com.alish.boilerplate.foo.presentation.models.FooUI
import com.alish.boilerplate.foo.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val getFooUseCase: GetFooUseCase,
    fetchFooPagingUseCase: FetchFooPagingUseCase
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.toUI() }
    }

    fun getFoo() = getFooUseCase().collectLocalRequestForList { it.toUI() }

    val fooPaging = fetchFooPagingUseCase().collectPagingRequest { it.toUI() }
}