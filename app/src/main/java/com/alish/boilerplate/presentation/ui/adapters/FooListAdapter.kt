package com.alish.boilerplate.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alish.boilerplate.base.BaseDiffUtilItemCallback
import com.alish.boilerplate.databinding.ItemFooBinding
import com.alish.boilerplate.domain.models.Foo

class FooListAdapter : ListAdapter<Foo, FooListAdapter.FooViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooViewHolder {
        return FooViewHolder(
            ItemFooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FooViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class FooViewHolder(
        private val binding: ItemFooBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Foo) = with(binding) {
            textItemFoo.text = item.bar
        }
    }
}