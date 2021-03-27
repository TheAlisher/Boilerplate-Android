package com.alis.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alis.boilerplate.databinding.ItemFooBinding
import com.alis.boilerplate.models.Foo

class FooAdapter : RecyclerView.Adapter<FooAdapter.FooViewHolder>() {

    private val list = mutableListOf<Foo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooViewHolder {
        return FooViewHolder(
            ItemFooBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FooViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class FooViewHolder(
        private val binding: ItemFooBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(foo: Foo) {
            binding.textItemFoo.text = foo.bar
        }
    }
}