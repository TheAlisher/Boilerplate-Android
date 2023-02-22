package com.alish.boilerplate.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * Base class for FlowFragments
 *
 * FlowFragment is [Fragment] that performs the functions of an activity in Single Activity Architecture, with its own
 * [FragmentContainerView][androidx.fragment.app.FragmentContainerView],
 * [NavGraph][androidx.navigation.NavGraph] and
 * [NavController][androidx.navigation.NavController]
 *
 * @param layoutId fragment layout id
 * @param navHostFragmentId id [FragmentContainerView][androidx.fragment.app.FragmentContainerView]
 *
 * @author Alish
 *
 * @see [com.alish.boilerplate.presentation.extensions.flowNavController]
 */
abstract class BaseFlowFragment(
    @LayoutRes layoutId: Int,
    @IdRes private val navHostFragmentId: Int
) : Fragment(layoutId) {

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        val navController = navHostFragment.navController

        setupNavigation(navController)
    }

    protected open fun setupNavigation(navController: NavController) {
    }
}