package com.alis.boilerplate.ui.fragments.koin

import androidx.lifecycle.ViewModel
import com.alis.boilerplate.data.repositories.KoinRepository

class KoinViewModel(
    private val repository: KoinRepository
) : ViewModel() {
    // …
}