package com.alish.boilerplate.presentation.ui.fragments.foopaging

import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import com.alish.boilerplate.presentation.base.BaseViewModel
import com.alish.boilerplate.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooPagingViewModel @Inject constructor(
    private val repository: FooRepositoryImpl
) : BaseViewModel() {

    fun fetchFooPaging() = repository.fetchFooPaging().collectPagingRequest { it.toUI() }
}