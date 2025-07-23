package com.alish.boilerplate.core.presentation.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder

fun <VH : ViewHolder> RecyclerView.setupRecycler(
    layoutManager: LayoutManager = LinearLayoutManager(context),
    adapter: Adapter<VH>
) = this.apply {
    this.layoutManager = layoutManager
    this.adapter = adapter
}