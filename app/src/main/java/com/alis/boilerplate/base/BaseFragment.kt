package com.alis.boilerplate.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

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