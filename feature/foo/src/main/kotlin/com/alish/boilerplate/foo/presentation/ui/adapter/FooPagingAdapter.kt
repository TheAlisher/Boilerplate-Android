package com.alish.boilerplate.foo.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alish.boilerplate.foo.databinding.ItemFooBinding
import com.alish.boilerplate.presentation.core.base.BaseDiffUtilItemCallback
import com.alish.boilerplate.foo.presentation.model.FooUI

class FooPagingAdapter : PagingDataAdapter<FooUI, FooPagingAdapter.FooPagingViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooPagingViewHolder {
        return FooPagingViewHolder(
            ItemFooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FooPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class FooPagingViewHolder(private val binding: ItemFooBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun onBind(item: FooUI) = with(binding) {
            textItemFoo.text = item.bar
        }
    }
}