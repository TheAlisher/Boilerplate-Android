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
import com.alis.boilerplate.ui.adapters.BoilerplatePagingAdapter
import com.alis.boilerplate.ui.adapters.paging.CommonLoadStateAdapter
import kotlinx.coroutines.launch

class PagingFragment : BaseFragment<PagingViewModel, FragmentPagingBinding>(
    R.layout.fragment_paging
) {

    override val viewModel: PagingViewModel by viewModels()
    override val binding: FragmentPagingBinding by viewBinding()

    private val boilerplateAdapter = BoilerplatePagingAdapter()

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() {
        binding.recyclerPaging.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = boilerplateAdapter.withLoadStateFooter(
                footer = CommonLoadStateAdapter { boilerplateAdapter.retry() }
            )
        }

        boilerplateAdapter.addLoadStateListener { loadStates ->
            binding.apply {
                progressPagingLoader.isVisible = loadStates.refresh is LoadState.Loading
                recyclerPaging.isVisible = loadStates.refresh !is LoadState.Loading
            }
        }
    }

    override fun setupRequests() {
        viewModel.fetchBoilerplate().observe(viewLifecycleOwner, {
            viewLifecycleOwner.lifecycleScope.launch {
                boilerplateAdapter.submitData(it)
            }
        })
    }
}