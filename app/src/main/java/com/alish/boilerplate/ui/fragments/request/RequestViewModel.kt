package com.alish.boilerplate.ui.fragments.request

import androidx.lifecycle.ViewModel
import com.alish.boilerplate.data.network.resource.Resource
import com.alish.boilerplate.data.repositories.RequestRepository
import com.alish.boilerplate.models.Foo
import kotlinx.coroutines.flow.Flow

class RequestViewModel(
    private val repository: RequestRepository
) : ViewModel() {

    fun fetchFoo(): Flow<Resource<Foo>> {
        return repository.fetchFoo()
    }
}