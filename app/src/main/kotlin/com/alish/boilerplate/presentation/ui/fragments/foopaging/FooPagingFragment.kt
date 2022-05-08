package com.alish.boilerplate.presentation.ui.fragments.foopaging

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentFooPagingBinding
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.presentation.ui.adapters.FooPagingAdapter
import com.alish.boilerplate.presentation.ui.adapters.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FooPagingFragment : BaseFragment<FooPagingViewModel, FragmentFooPagingBinding>(
    R.layout.fragment_foo_paging
) {

    override val viewModel: FooPagingViewModel by viewModels()
    override val binding by viewBinding(FragmentFooPagingBinding::bind)

    private val fooPagingAdapter = FooPagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        with(recyclerFooPaging) {
            layoutManager = LinearLayoutManager(context)
            adapter = fooPagingAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { fooPagingAdapter.retry() }
            )
        }

        fooPagingAdapter.addLoadStateListener { loadStates ->
            recyclerFooPaging.isVisible = loadStates.refresh is LoadState.NotLoading
            loaderFooPaging.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchFooPaging()
    }

    private fun fetchFooPaging() {
        viewModel.fetchFooPaging().collectPaging {
            fooPagingAdapter.submitData(it)
        }
    }
}