package com.alish.boilerplate.ui.fragments.koin

import androidx.lifecycle.ViewModel
import com.alish.boilerplate.data.repositories.KoinRepository

class KoinViewModel(
    private val repository: KoinRepository
) : ViewModel() {
    // …
}