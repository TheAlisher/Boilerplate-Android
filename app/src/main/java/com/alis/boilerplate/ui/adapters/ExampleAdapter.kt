package com.alis.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alis.boilerplate.databinding.ItemExampleBinding
import com.alis.boilerplate.models.ExampleData

class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    private val list = mutableListOf<ExampleData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder(
            ItemExampleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ExampleViewHolder(
        private val binding: ItemExampleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(exampleData: ExampleData) {
            binding.apply {
                textExampleTitle.text = exampleData.title
                textExampleDescription.text = exampleData.description
            }
        }
    }
}