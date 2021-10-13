package com.alish.boilerplate.ui.fragments.paging

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.domain.usecases.foo.FooPagingUseCase
import kotlinx.coroutines.flow.Flow

class PagingViewModel(
    private val fooPagingUseCase: FooPagingUseCase
) : BaseViewModel() {

    fun fetchFooPaging(): Flow<PagingData<Foo>> {
        return fooPagingUseCase().cachedIn(viewModelScope)
    }
}