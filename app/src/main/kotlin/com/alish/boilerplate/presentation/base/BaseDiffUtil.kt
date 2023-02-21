package com.alish.boilerplate.presentation.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Interface for [BaseDiffUtilItemCallback]
 *
 * @see equals
 */
interface IBaseDiffModel<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}

/**
 * Base class for fast create [DiffUtil] in
 * [ListAdapter][androidx.recyclerview.widget.ListAdapter], [PagingAdapter][androidx.paging.PagingDataAdapter]
 *
 * @see IBaseDiffModel
 * @see DiffUtil.ItemCallback
 */
class BaseDiffUtilItemCallback<T : IBaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}