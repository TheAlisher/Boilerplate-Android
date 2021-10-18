package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import com.alish.boilerplate.presentation.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fooUseCase: FooUseCase,
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    private val fooState = State<Foo>()
    val fooLoading: LiveData<Boolean> = fooState.isLoading
    val fooError: LiveData<String> = fooState.error
    val fooData: LiveData<Foo> = fooState.data

    fun fetchFoo() {
        viewModelScope.launch {
            subscribeTo(fooState) {
                fooUseCase()
            }
        }
    }


    /*fun fetchFoo() {
        viewModelScope.launch {
            fooUseCase().collect {
                _fooLoading.bindToResourceLoading(it)
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Error -> {
                        it.message?.let { error ->
                            _fooError.value = error
                        }
                    }
                    is Resource.Success -> {
                        it.data?.let { data ->
                            _fooData.value = data
                        }
                    }
                }
            }
        }
    }*/

    fun fetchFooPaging() = repository.fetchFooPaging()
}