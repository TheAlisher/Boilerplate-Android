package com.alish.boilerplate.foo.presentation.ui.fragment

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.foo.R
import com.alish.boilerplate.foo.databinding.FragmentFooBinding
import com.alish.boilerplate.foo.presentation.ui.adapter.FooPagingAdapter
import com.alish.boilerplate.presentation.core.base.BaseFragment
import com.alish.boilerplate.presentation.core.extensions.launchAndCollectIn
import com.alish.boilerplate.presentation.core.extensions.setupRecycler
import com.alish.boilerplate.presentation.core.extensions.showToastLong
import com.alish.boilerplate.presentation.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.io.InterruptedIOException

@AndroidEntryPoint
class FooFragment : BaseFragment<FooViewModel, FragmentFooBinding>(R.layout.fragment_foo) {

    override val viewModel: FooViewModel by viewModels()
    override val binding by viewBinding(FragmentFooBinding::bind)

    private val fooPagingAdapter = FooPagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        recyclerFooPaging.setupRecycler(
            adapter = fooPagingAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { fooPagingAdapter.retry() }
            )
        )

        fooPagingAdapter.addLoadStateListener { loadStates ->
            recyclerFooPaging.isVisible = loadStates.refresh is LoadState.NotLoading
            loaderFoo.isVisible = loadStates.refresh is LoadState.Loading

            if (loadStates.refresh is LoadState.Error) {
                if ((loadStates.refresh as LoadState.Error).error is InterruptedIOException) {
                    showToastLong("Timeout")
                }
            }
        }
    }

    override fun setupRequests() {
        fetchFoo()
    }

    private fun fetchFoo() {
        viewModel.fetchFoo()
        fetchFooPaging()
    }

    private fun fetchFooPaging() {
        viewModel.fooPaging.collectPaging {
            fooPagingAdapter.submitData(it)
        }
    }

    override fun setupSubscribers() {
        subscribeToFoo()
    }

    private fun subscribeToFoo() = with(binding) {
        viewModel.fooState.collectAsUIState(
            state = {
                it.setupViewVisibility(groupFoo, loaderFoo)
            },
            onSuccess = {
                textFoo.text = it.bar
            }
        )

        viewModel.getFooList().launchAndCollectIn(viewLifecycleOwner) {
            it.map { data ->
                textFoo.text = data.bar
            }
        }
    }
}