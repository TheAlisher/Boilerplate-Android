package com.alish.boilerplate.foo.presentation.ui.fragments.foopaging

import com.alish.boilerplate.domain.usecases.foopaging.FetchFooPagingUseCase
import com.alish.boilerplate.presentation.core.base.BaseViewModel
import com.alish.boilerplate.foo.presentation.models.foo.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooPagingViewModel @Inject constructor(
    fetchFooPagingUseCase: FetchFooPagingUseCase
) : BaseViewModel() {

    val fooPaging = fetchFooPagingUseCase().collectPagingRequest { it.toUI() }
}