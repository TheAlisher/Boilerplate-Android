package com.alish.boilerplate.ui.fragments.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alish.boilerplate.base.BaseViewModel
import com.alish.boilerplate.data.repositories.PagingRepository
import com.alish.boilerplate.models.paging.FooPagingData

class PagingViewModel(
    private val repository: PagingRepository
) : BaseViewModel() {

    fun fetchFooPaging(): LiveData<PagingData<FooPagingData>> {
        return repository.fetchFooPaging().cachedIn(viewModelScope)
    }
}