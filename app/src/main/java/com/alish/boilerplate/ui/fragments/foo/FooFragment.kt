package com.alish.boilerplate.ui.fragments.foo

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.base.BaseFragment
import com.alish.boilerplate.data.resource.Resource
import com.alish.boilerplate.databinding.FragmentFooBinding
import com.alish.boilerplate.extensions.bindToResourceLoading
import com.alish.boilerplate.ui.adapters.FooPagingAdapter
import com.alish.boilerplate.ui.adapters.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.fetchFoo().collect {
                binding.loaderFoo.bindToResourceLoading(it)
                when (it) {
                    is Resource.Loading -> {
                        // …
                    }
                    is Resource.Error -> {
                        // …
                    }
                    is Resource.Success -> {
                        // …
                    }
                }
            }
        }
    }

    private fun fetchFooPaging() {
        lifecycleScope.launch {
            viewModel.fetchFooPaging().collectLatest {
                fooPagingAdapter.submitData(it)
            }
        }
    }
}