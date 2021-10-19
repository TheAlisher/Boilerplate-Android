package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import com.alish.boilerplate.presentation.state.StateView
import com.alish.boilerplate.presentation.state.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fooUseCase: FooUseCase,
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    private val _fooState = StateViewModel<Foo>()
    val fooState = StateView<Foo>(
        _fooState.isLoading,
        _fooState.error,
        _fooState.data
    )

    fun fetchFoo() {
        viewModelScope.launch {
            subscribeTo(_fooState) {
                fooUseCase()
            }
        }
    }

    fun fetchFooPaging() = repository.fetchFooPaging()
}