package com.alis.boilerplate.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel
    protected abstract val binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObservers()
    }

    open fun initialize() {

    }

    open fun setupViews() {

    }

    open fun setupListeners() {

    }

    open fun setupRequests() {

    }

    open fun setupObservers() {

    }
}