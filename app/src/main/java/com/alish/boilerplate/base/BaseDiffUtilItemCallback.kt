package com.alish.boilerplate.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Base Comparator
 */

class BaseDiffUtilItemCallback<N : Number, T : IBaseDiffModel<N>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}