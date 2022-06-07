package com.alish.boilerplate.presentation.base

import androidx.recyclerview.widget.DiffUtil

interface IBaseDiffModel<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}

class BaseDiffUtilItemCallback<T : IBaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}