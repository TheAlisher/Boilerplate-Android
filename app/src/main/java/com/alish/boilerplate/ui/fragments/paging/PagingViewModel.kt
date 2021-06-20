package com.alish.boilerplate.ui.fragments.paging

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.data.repositories.PagingRepository
import com.alish.boilerplate.models.paging.FooPagingData
import kotlinx.coroutines.flow.Flow

class PagingViewModel(
    private val repository: PagingRepository
) : BaseViewModel() {

    fun fetchFooPaging(): Flow<PagingData<FooPagingData>> {
        return repository.fetchFooPaging().cachedIn(viewModelScope)
    }
}