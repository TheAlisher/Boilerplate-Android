package com.alish.boilerplate.ui.fragments.foo

import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.domain.usecases.foo.FooPagingUseCase
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fooUseCase: FooUseCase,
    private val fooPagingUseCase: FooPagingUseCase
) : BaseViewModel() {

    fun fetchFoo() = fooUseCase()

    fun fetchFooPaging() = fooPagingUseCase()
}