package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.databinding.FragmentFooBinding
import com.alish.boilerplate.presentation.extensions.setupApiErrors
import com.alish.boilerplate.presentation.extensions.setupUnexpectedErrors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FooFragment : BaseFragment<FooViewModel, FragmentFooBinding>(R.layout.fragment_foo) {

    override val viewModel: FooViewModel by viewModels()
    override val binding by viewBinding(FragmentFooBinding::bind)

    override fun setupRequests() {
        fetchFoo()
    }

    private fun fetchFoo() {
        viewModel.fetchFoo()
    }

    override fun setupSubscribers() {
        subscribeToFoo()
    }

    private fun subscribeToFoo() = with(binding) {
        viewModel.fooState.collectUIState(
            state = {
                it.setupViewVisibility(groupFoo, loaderFoo)
            },
            onError = {
                it.setupApiErrors()
                it.setupUnexpectedErrors(this@FooFragment)
            },
            onSuccess = {
                textFoo.text = it.bar
            }
        )
    }
}