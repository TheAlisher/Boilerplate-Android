package com.alis.boilerplate.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<ViewModel : BaseViewModel>(layoutID: Int) : Fragment(layoutID) {

    protected abstract val viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupObservers()
    }

    abstract fun initialize()

    abstract fun setupListeners()

    abstract fun setupObservers()
}