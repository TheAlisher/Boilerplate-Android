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
import com.alish.boilerplate.presentation.core.extensions.launchAndCollectIn
import com.alish.boilerplate.presentation.core.extensions.launchAndCollectLatestIn
import com.alish.boilerplate.presentation.core.extensions.launchWithRepeatOnLifecycle
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.flow.*

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
     * Collect [UIState] with [launchAndCollectIn]
     *
     * @receiver [StateFlow] with [UIState]
     *
     * @param state optional, for working with all states
     * @param onError for error handling
     * @param onSuccess for working with data
     */
    inline fun <T> StateFlow<UIState<T>>.collectAsUIState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        noinline state: ((UIState<T>) -> Unit)? = null,
        crossinline onError: ((error: NetworkError) -> Unit),
        crossinline onSuccess: ((data: T) -> Unit)
    ) {
        launchAndCollectIn(viewLifecycleOwner, lifecycleState) {
            state?.invoke(it)
            when (it) {
                is UIState.Idle -> {}
                is UIState.Loading -> {}
                is UIState.Error -> onError.invoke(it.error)
                is UIState.Success -> onSuccess.invoke(it.data)
            }
        }
    }

    /**
     * Collect [PagingData] with [launchWithRepeatOnLifecycle]
     *
     * @receiver [Flow] with [PagingData]
     */
    protected fun <T : Any> Flow<PagingData<T>>.collectPaging(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        action: suspend (value: PagingData<T>) -> Unit
    ) {
        launchAndCollectLatestIn(viewLifecycleOwner, lifecycleState) {
            action(it)
        }
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
        is NetworkError.Timeout -> showToastLong("Timeout")
        is NetworkError.Unexpected -> showToastLong(this.errorMessage)
        is NetworkError.Api -> this.errorMessage?.let { showToastLong(it) }

        is NetworkError.ApiInputs -> {
            inputs.forEach { input ->
                inputErrors?.get(input.tag).also { message ->
                    if (message == null) {
                        input.isErrorEnabled = false
                    } else {
                        input.error = message.joinToString()
                        this.inputErrors?.remove(input.tag)
                    }
                }
            }
        }
    }
}