package com.alish.boilerplate.presentation.ui.fragments.foo

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.databinding.FragmentFooBinding
import com.alish.boilerplate.presentation.extensions.showToastShort
import com.alish.boilerplate.presentation.ui.adapters.FooPagingAdapter
import com.alish.boilerplate.presentation.ui.adapters.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FooFragment : BaseFragment<FooViewModel, FragmentFooBinding>(R.layout.fragment_foo) {

    override val viewModel: FooViewModel by viewModels()
    override val binding by viewBinding(FragmentFooBinding::bind)

    private val fooPagingAdapter = FooPagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        with(recyclerFoo) {
            layoutManager = LinearLayoutManager(context)
            adapter = fooPagingAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { fooPagingAdapter.retry() }
            )
        }

        fooPagingAdapter.addLoadStateListener { loadStates ->
            recyclerFoo.isVisible = loadStates.refresh is LoadState.NotLoading
            loaderFoo.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchFoo()
        fetchFooPaging()
    }

    private fun fetchFoo() {
        viewModel.fetchFoo()
    }

    private fun fetchFooPaging() {
        viewModel.fetchFooPaging().collectPaging {
            fooPagingAdapter.submitData(it)
        }
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
                showToastShort(it)
            },
            onSuccess = {
                textFoo.text = it.bar
            }
        )
    }
}