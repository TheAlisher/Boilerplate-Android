package com.alish.boilerplate.ui.fragments.request

import androidx.lifecycle.ViewModel
import com.alish.boilerplate.data.resource.Resource
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooUseCase
import kotlinx.coroutines.flow.Flow

class RequestViewModel(
    private val fooUseCase: FooUseCase
) : ViewModel() {

    fun fetchFoo(): Flow<Resource<Foo>> {
        return fooUseCase()
    }
}