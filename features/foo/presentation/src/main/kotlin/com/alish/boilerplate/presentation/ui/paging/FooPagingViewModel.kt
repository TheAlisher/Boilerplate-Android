package com.alish.boilerplate.presentation.ui.paging

import com.alish.boilerplate.domain.usecases.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooPagingViewModel @Inject constructor(
    fetchFooPagingUseCase: FetchFooPagingUseCase,
) : BaseViewModel() {

    val fooPaging = fetchFooPagingUseCase().collectPagingRequest { it.toUI() }
}