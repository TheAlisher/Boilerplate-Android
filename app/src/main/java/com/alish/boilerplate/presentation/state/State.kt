package com.alish.boilerplate.presentation.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.base.BaseViewModel
import kotlin.reflect.KProperty

class StateViewModel<T>(
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(),
    val error: MutableLiveData<String> = MutableLiveData(),
    val data: MutableLiveData<T> = MutableLiveData()
)

class StateView<T>(
    val isLoading: LiveData<Boolean>,
    val error: LiveData<String>,
    val data: LiveData<T>
)

class StateDelegate<T>(
    private val stateViewModel: StateViewModel<T>
) {
    operator fun getValue(thisRef: BaseViewModel, property: KProperty<*>): StateView<T> {
        return StateView(stateViewModel.isLoading, stateViewModel.error, stateViewModel.data)
    }
}