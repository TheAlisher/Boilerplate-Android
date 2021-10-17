package com.alish.boilerplate.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alish.boilerplate.common.resource.Resource

abstract class BaseViewModel : ViewModel() {

    protected fun <T> MutableLiveData<Boolean>.bindToResourceLoading(resource: Resource<T>) {
        value = resource is Resource.Loading
    }
}