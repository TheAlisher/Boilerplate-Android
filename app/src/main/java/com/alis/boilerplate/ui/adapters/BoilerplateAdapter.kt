package com.alis.boilerplate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alis.boilerplate.databinding.ItemBoilerplateBinding
import com.alis.boilerplate.models.Boilerplate

class BoilerplateAdapter : RecyclerView.Adapter<BoilerplateAdapter.BoilerplateViewHolder>() {

    private val list = mutableListOf<Boilerplate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoilerplateViewHolder {
        return BoilerplateViewHolder(
            ItemBoilerplateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BoilerplateViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class BoilerplateViewHolder(
        private val binding: ItemBoilerplateBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(boilerplate: Boilerplate) {
            binding.textItemBoilerplate.text = boilerplate.foo
        }
    }
}