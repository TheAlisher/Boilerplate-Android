package com.alish.boilerplate.features.foo.ui

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.databinding.FragmentFooBinding
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
            },
            onSuccess = {
                textFoo.text = it.bar
            }
        )

        viewModel.getFoo().collectSafely {
            it.map { data ->
                textFoo.text = data.bar
            }
        }
    }
}