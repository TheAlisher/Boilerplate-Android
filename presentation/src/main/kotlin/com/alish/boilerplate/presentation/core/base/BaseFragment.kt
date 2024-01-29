package com.alish.boilerplate.presentation.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.paging.PagingData
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.domain.core.NetworkError
import com.alish.boilerplate.presentation.core.extensions.showToastLong
import com.alish.boilerplate.presentation.core.UIState
import com.alish.boilerplate.presentation.core.extensions.collectAsUIState
import com.alish.boilerplate.presentation.core.extensions.launchAndCollect
import com.alish.boilerplate.presentation.core.extensions.launchWithRepeatOnLifecycle
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

/**
 * Base class for [Fragment]s that work with data
 *
 * @author Alish
 */
abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    @LayoutRes
    layoutId: Int,
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel
    protected abstract val binding: Binding

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupRequests()
        setupSubscribers()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupSubscribers() {
    }

    /**
     * @see [collectAsUIState]
     * */
    protected inline fun <T> StateFlow<UIState<T>>.collectUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        noinline state: ((UIState<T>) -> Unit)? = null,
        crossinline onError: ((error: NetworkError) -> Unit),
        crossinline onSuccess: ((data: T) -> Unit)
    ) {
        collectAsUIState(
            viewLifecycleOwner = viewLifecycleOwner,
            lifecycleState = lifecycleState,
            state = state,
            onError = onError,
            onSuccess = onSuccess
        )
    }

    /**
     * @see [launchAndCollect]
     */
    protected inline fun <T> Flow<T>.collectSafely(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        crossinline collector: suspend CoroutineScope.(T) -> Unit
    ) {
        launchAndCollect(
            viewLifecycleOwner = viewLifecycleOwner,
            state = state,
            collector = collector
        )
    }

    /**
     * Collect [PagingData] with [launchRepeatOnLifecycle]
     *
     * @receiver [Flow] with [PagingData]
     */
    protected fun <T : Any> Flow<PagingData<T>>.collectPaging(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: suspend (value: PagingData<T>) -> Unit
    ) {
        viewLifecycleOwner.launchWithRepeatOnLifecycle(
            lifecycleState
        ) { this@collectPaging.collectLatest { action(it) } }
    }

    /**
     * Setup views visibility depending on [UIState] states.
     *
     * @receiver [UIState]
     *
     * @param willShowViewIfSuccess whether to show views if the request is successful
     */
    protected fun <T> UIState<T>.setupViewVisibility(
        group: Group,
        loader: CircularProgressIndicator,
        willShowViewIfSuccess: Boolean = true
    ) {
        fun showLoader(isVisible: Boolean) {
            group.isVisible = !isVisible
            loader.isVisible = isVisible
        }

        when (this) {
            is UIState.Idle -> {}
            is UIState.Loading -> showLoader(true)
            is UIState.Error -> showLoader(false)
            is UIState.Success -> showLoader(!willShowViewIfSuccess)
        }
    }

    /**
     * Extension function for setup errors from server side
     *
     * @receiver [NetworkError]
     */
    protected fun NetworkError.setupApiErrors(vararg inputs: TextInputLayout) = when (this) {
        is NetworkError.Unexpected -> {
            showToastLong(this.error)
        }

        is NetworkError.Api -> {
            this.error?.let { showToastLong(it) }
        }

        is NetworkError.ApiInputs -> {
            for (input in inputs) {
                error?.get(input.tag).also { error ->
                    if (error == null) {
                        input.isErrorEnabled = false
                    } else {
                        input.error = error.joinToString()
                        this.error?.remove(input.tag)
                    }
                }
            }
        }

        is NetworkError.Timeout -> {
            showToastLong("Timeout")
        }
    }
}