package com.alish.boilerplate.core.presentation.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Interface for [BaseDiffUtilItemCallback]
 *
 * @author Alish
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
 * @author Alish
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