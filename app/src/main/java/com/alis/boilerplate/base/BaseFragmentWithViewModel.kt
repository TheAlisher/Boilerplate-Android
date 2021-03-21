package com.alis.boilerplate.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes

abstract class BaseFragmentWithViewModel<ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : BaseFragment(layoutId) {

    protected lateinit var viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObservers()
    }
}