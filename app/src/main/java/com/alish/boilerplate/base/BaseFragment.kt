package com.alish.boilerplate.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.R

abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel
    protected abstract val binding: Binding
    protected lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPermissionsLaunchers()
    }

    open fun setupPermissionsLaunchers() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainNavController = requireActivity().findNavController(R.id.nav_host_fragment)

        initialize()
        setupArgs()
        setupListeners()
        setupRequests()
        setupObservers()
    }

    open fun initialize() {
    }

    open fun setupArgs() {
    }

    open fun setupListeners() {
    }

    open fun setupRequests() {
    }

    open fun setupObservers() {
    }
}