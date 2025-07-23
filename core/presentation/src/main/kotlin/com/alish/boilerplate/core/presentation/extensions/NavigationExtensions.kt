package com.alish.boilerplate.core.presentation.extensions

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.alish.boilerplate.presentation.R

/**
 * Init [NavController]
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * class Activity : AppCompatActivity() {
 *
 *     private val navController by lazy { initNavController(R.id.nav_host_fragment) }
 * }
 * ```
 *
 * @receiver [AppCompatActivity]
 *
 * @param navHostId Fragment Container view id
 *
 * @see [NavController]
 * @see [NavHostFragment]
 */
fun AppCompatActivity.initNavController(@IdRes navHostId: Int): NavController {
    val navHostFragment =
        supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
    return navHostFragment.navController
}

/**
 * Get activity nav controller with [MainNavHostId][R.id.nav_host_fragment]
 *
 * @receiver [Fragment]
 *
 * @see [findNavController]
 */
fun Fragment.activityNavController() = requireActivity().findNavController(R.id.nav_host_fragment)

/**
 * Get flow nav controller with [FragmentContainerView][androidx.fragment.app.FragmentContainerView] id
 *
 * @receiver [Fragment]
 *
 * @param navHostId flow container view id
 */
fun Fragment.flowNavController(@IdRes navHostId: Int) = requireActivity().findNavController(
    navHostId
)

/**
 * Safely navigate to a destination from the current navigation graph.
 *
 * Safer than usual because there is a check if we are already at the destination.
 *
 * @param actionId an [action][NavDestination.getAction] id or a destination id to navigate to
 *
 * @see [NavDestination.getAction]
 */
fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

/**
 * Safely navigate to a destination from the current navigation graph.
 *
 * Safer than usual because there is a check if we are already at the destination.
 *
 * @param directions directions that describe this navigation operation
 *
 * @see [NavDestination.getAction]
 */
fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}

/**
 * Extension for easy override on back pressed
 *
 * @receiver [Fragment]
 *
 * @param onBackPressed custom back pressed implementation
 *
 * @see OnBackPressedCallback
 */
fun Fragment.overrideOnBackPressed(onBackPressed: OnBackPressedCallback.() -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}

/**
 * Get parent fragment if parent fragment is [FlowFragment][com.alish.boilerplate.core.presentation.base.BaseFlowFragment].
 *
 * &nbsp
 *
 * ## How to use:
 * ```
 * private val args by lazy {
 *     parentFragmentInNavHost<MainFlowFragment>().args
 * }
 *
 * // or
 *
 * val bottomNavigationView = parentFragmentInNavHost<MainFlowFragment>()
 *     .requireView()
 *     .findViewById<BottomNavigationView>(R.id.bottom_navigation)
 * ```
 *
 * @receiver [Fragment]
 *
 * @param T parent fragment generic
 *
 *
 * @see [Fragment.getParentFragment]
 * @see [NavHostFragment]
 */
inline fun <reified T : Fragment> Fragment.parentFragmentInNavHost(): T {
    return ((parentFragment as NavHostFragment).parentFragment as T)
}