package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.common.resource.Resource
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooPagingUseCase
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fooUseCase: FooUseCase,
    private val fooPagingUseCase: FooPagingUseCase
) : BaseViewModel() {

    private val _fooLoading = MutableLiveData<Boolean>()
    val fooLoading: LiveData<Boolean> = _fooLoading
    private val _fooError = MutableLiveData<String>()
    val fooError: LiveData<String> = _fooError
    private val _fooData = MutableLiveData<Foo>()
    val fooData: LiveData<Foo> = _fooData

    fun fetchFoo() {
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
    }

    fun fetchFooPaging() = fooPagingUseCase()
}