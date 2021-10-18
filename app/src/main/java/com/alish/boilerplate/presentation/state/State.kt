package com.alish.boilerplate.presentation.state

import androidx.lifecycle.MutableLiveData

class State<T>(
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(),
    val error: MutableLiveData<String> = MutableLiveData(),
    val data: MutableLiveData<T> = MutableLiveData()
)