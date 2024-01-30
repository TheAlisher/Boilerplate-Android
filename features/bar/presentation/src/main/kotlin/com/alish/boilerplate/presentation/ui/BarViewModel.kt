package com.alish.boilerplate.presentation.ui

import com.alish.boilerplate.domain.usecases.FetchBarUseCase
import com.alish.boilerplate.presentation.core.MutableUIStateFlow
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.presentation.models.BarUI
import com.alish.boilerplate.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BarViewModel @Inject constructor(
    private val fetchBarUseCase: FetchBarUseCase,
) : BaseViewModel() {

    private val _barState = MutableUIStateFlow<BarUI>()
    val barState = _barState.asStateFlow()

    fun fetchBar() {
        fetchBarUseCase().collectNetworkRequest(_barState) { it.toUI() }
    }
}