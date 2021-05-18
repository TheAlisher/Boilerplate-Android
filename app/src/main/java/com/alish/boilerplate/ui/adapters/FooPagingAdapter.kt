package com.alish.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alish.boilerplate.databinding.ItemFooBinding
import com.alish.boilerplate.models.paging.FooPagingData

class FooPagingAdapter : PagingDataAdapter<FooPagingData, FooPagingAdapter.FooPagingViewHolder>(
    FooComparator
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooPagingViewHolder {
        return FooPagingViewHolder(
            ItemFooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FooPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    companion object {
        object FooComparator : DiffUtil.ItemCallback<FooPagingData>() {
            override fun areItemsTheSame(oldItem: FooPagingData, newItem: FooPagingData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FooPagingData, newItem: FooPagingData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class FooPagingViewHolder(private val binding: ItemFooBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun onBind(item: FooPagingData) {
            binding.textItemFoo.text = item.bar
        }
    }
}