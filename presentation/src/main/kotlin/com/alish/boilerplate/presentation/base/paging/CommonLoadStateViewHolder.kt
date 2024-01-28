package com.alish.boilerplate.presentation.base.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.alish.boilerplate.presentation.R
import com.alish.boilerplate.presentation.databinding.LoadStateFooterViewItemBinding

class CommonLoadStateViewHolder(
    private val binding: LoadStateFooterViewItemBinding,
    retry: () -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) = with(binding) {
        if (loadState is LoadState.Error) {
            errorMsg.text = loadState.error.localizedMessage
        }

        progressBar.isVisible = loadState is LoadState.Loading
        retryButton.isVisible = loadState is LoadState.Error
        errorMsg.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CommonLoadStateViewHolder {
            val view = LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.load_state_footer_view_item, parent, false
            )
            val binding = LoadStateFooterViewItemBinding.bind(view)
            return CommonLoadStateViewHolder(binding, retry)
        }
    }
}