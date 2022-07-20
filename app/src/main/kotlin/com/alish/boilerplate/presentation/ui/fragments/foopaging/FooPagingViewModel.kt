package com.alish.boilerplate.presentation.ui.fragments.foopaging

import com.alish.boilerplate.domain.usecases.foopaging.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.base.BaseViewModel
import com.alish.boilerplate.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooPagingViewModel @Inject constructor(
    private val fetchFooPagingUseCase: FetchFooPagingUseCase
) : BaseViewModel() {

    fun fetchFooPaging() = fetchFooPagingUseCase().collectPagingRequest { it.toUI() }
}