package com.alis.boilerplate.ui.fragments.paging

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alis.boilerplate.R
import com.alis.boilerplate.base.BaseFragment
import com.alis.boilerplate.databinding.FragmentPagingBinding
import com.alis.boilerplate.ui.adapters.FooPagingAdapter
import com.alis.boilerplate.ui.adapters.paging.CommonLoadStateAdapter
import kotlinx.coroutines.launch

class PagingFragment : BaseFragment<PagingViewModel, FragmentPagingBinding>(
    R.layout.fragment_paging
) {

    override val viewModel: PagingViewModel by viewModels()
    override val binding: FragmentPagingBinding by viewBinding()

    private val fooPagingAdapter = FooPagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() {
        binding.recyclerPaging.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = fooPagingAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { fooPagingAdapter.retry() }
            )
        }

        fooPagingAdapter.addLoadStateListener { loadStates ->
            binding.apply {
                recyclerPaging.isVisible = loadStates.refresh is LoadState.NotLoading
                progressPagingLoader.isVisible = loadStates.refresh is LoadState.Loading
            }
        }
    }

    override fun setupRequests() {
        viewModel.fetchFooPagingData().observe(viewLifecycleOwner, {
            viewLifecycleOwner.lifecycleScope.launch {
                fooPagingAdapter.submitData(it)
            }
        })
    }
}