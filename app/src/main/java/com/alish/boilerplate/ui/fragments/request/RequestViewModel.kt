package com.alish.boilerplate.ui.fragments.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alish.boilerplate.data.network.resource.Resource
import com.alish.boilerplate.data.repositories.RequestRepository
import com.alish.boilerplate.models.Foo

class RequestViewModel(
    private val repository: RequestRepository
) : ViewModel() {

    fun fetchFoo(): LiveData<Resource<Foo>> {
        return repository.fetchFoo()
    }
}