package com.alish.boilerplate.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.domain.utils.NetworkError
import com.alish.boilerplate.presentation.extensions.showToastLong
import com.alish.boilerplate.presentation.ui.state.UIState
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Base class for [Fragment]s that work with data
 *
 * @author Alish
 */
abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewBinding>(
    @LayoutRes layoutId: Int
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
     * Collect [UIState] with [launchRepeatOnLifecycle]
     *
     * @receiver [StateFlow] with [UIState]
     *
     * @param state optional, for working with all states
     * @param onError for error handling
     * @param onSuccess for working with data
     */
    protected fun <T> StateFlow<UIState<T>>.collectUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        state: ((UIState<T>) -> Unit)? = null,
        onError: ((error: NetworkError) -> Unit),
        onSuccess: ((data: T) -> Unit)
    ) {
        launchRepeatOnLifecycle(lifecycleState) {
            this@collectUIState.collect {
                state?.invoke(it)
                when (it) {
                    is UIState.Idle -> {}
                    is UIState.Loading -> {}
                    is UIState.Error -> onError.invoke(it.error)
                    is UIState.Success -> onSuccess.invoke(it.data)
                }
            }
        }
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
        launchRepeatOnLifecycle(lifecycleState) { this@collectPaging.collectLatest { action(it) } }
    }

    /**
     * Setup views visibility depending on [UIState] states.
     *
     * @receiver [UIState]
     *
     * @param isNavigateIfSuccess whether to show views if the request is successful
     */
    protected fun <T> UIState<T>.setupViewVisibility(
        group: Group, loader: CircularProgressIndicator, isNavigateIfSuccess: Boolean = false
    ) {
        fun showLoader(isVisible: Boolean) {
            group.isVisible = !isVisible
            loader.isVisible = isVisible
        }

        when (this) {
            is UIState.Idle -> {}
            is UIState.Loading -> showLoader(true)
            is UIState.Error -> showLoader(false)
            is UIState.Success -> if (!isNavigateIfSuccess) showLoader(false)
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
            showToastLong(this.error)
        }
        is NetworkError.ApiInputs -> {
            for (input in inputs) {
                error[input.tag].also { error ->
                    if (error == null) {
                        input.isErrorEnabled = false
                    } else {
                        input.error = error.joinToString()
                        this.error.remove(input.tag)
                    }
                }
            }
        }
    }

    /**
     * Launch coroutine with [repeatOnLifecycle] API
     *
     * @param state [Lifecycle.State][androidx.lifecycle.Lifecycle.State] in which `block` runs in a new coroutine. That coroutine
     * will cancel if the lifecycle falls below that state, and will restart if it's in that state
     * again.
     * @param block The block to run when the lifecycle is at least in [state] state.
     */
    private fun launchRepeatOnLifecycle(
        state: Lifecycle.State,
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state) {
                block()
            }
        }
    }
}