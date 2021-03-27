package com.alis.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alis.boilerplate.databinding.ItemBoilerplateBinding
import com.alis.boilerplate.models.Boilerplate

class BoilerplatePagingAdapter(
) : PagingDataAdapter<Boilerplate, BoilerplatePagingAdapter.BoilerplatePagingViewHolder>(
    BoilerplateComparator
) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BoilerplatePagingAdapter.BoilerplatePagingViewHolder {
        return BoilerplatePagingViewHolder(
            ItemBoilerplateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BoilerplatePagingAdapter.BoilerplatePagingViewHolder, position: Int
    ) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class BoilerplatePagingViewHolder(
        private val binding: ItemBoilerplateBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Boilerplate) {
            binding.textItemBoilerplate.text = item.foo
        }
    }

    companion object {
        object BoilerplateComparator : DiffUtil.ItemCallback<Boilerplate>() {
            override fun areItemsTheSame(oldItem: Boilerplate, newItem: Boilerplate): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Boilerplate, newItem: Boilerplate): Boolean {
                return oldItem == newItem
            }
        }
    }
}