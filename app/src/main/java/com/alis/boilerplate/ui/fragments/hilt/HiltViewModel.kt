package com.alis.boilerplate.ui.fragments.hilt

import androidx.lifecycle.ViewModel
import com.alis.boilerplate.data.repositories.HiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltViewModel @Inject constructor(
    private val repository: HiltRepository
) : ViewModel() {
    // …
}