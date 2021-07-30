package com.alish.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alish.boilerplate.databinding.ItemFooBinding
import com.alish.boilerplate.models.Foo

class FooListAdapter : ListAdapter<Foo, FooListAdapter.FooViewHolder>(FooDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooViewHolder {
        return FooViewHolder(
            ItemFooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FooViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class FooDiffCallback : DiffUtil.ItemCallback<Foo>() {
        override fun areItemsTheSame(oldItem: Foo, newItem: Foo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Foo, newItem: Foo): Boolean {
            return oldItem == newItem
        }
    }

    inner class FooViewHolder(
        private val binding: ItemFooBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Foo) = with(binding) {
            textItemFoo.text = item.bar
        }
    }
}