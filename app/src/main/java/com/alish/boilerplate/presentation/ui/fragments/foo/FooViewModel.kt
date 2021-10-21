package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import com.alish.boilerplate.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fooUseCase: FooUseCase,
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    private val _fooState = MutableLiveData<UIState<Foo>>()
    val fooState: LiveData<UIState<Foo>> = _fooState

    fun fetchFoo() {
        subscribeTo(_fooState) {
            fooUseCase()
        }
    }

    fun fetchFooPaging() = repository.fetchFooPaging()
}