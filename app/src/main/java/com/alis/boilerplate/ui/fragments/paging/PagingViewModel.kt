package com.alis.boilerplate.ui.fragments.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alis.boilerplate.base.BaseViewModel
import com.alis.boilerplate.data.repositories.PagingRepository
import com.alis.boilerplate.models.Boilerplate

class PagingViewModel(
    private val repository: PagingRepository
) : BaseViewModel() {

    fun fetchBoilerplate(): LiveData<PagingData<Boilerplate>> {
        return repository.fetchBoilerplate().cachedIn(viewModelScope)
    }
}