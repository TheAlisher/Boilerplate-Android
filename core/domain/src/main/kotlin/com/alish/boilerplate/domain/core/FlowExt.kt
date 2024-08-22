package com.alish.boilerplate.domain.core

import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * [FlowExt] - only for docs and links
 */
private class FlowExt

/**
 * Transforms each element in a [list][List] emitted by a [Flow] using the provided [transform] function.
 *
 * This function is an inline extension for a [Flow] that emits a [list][List] of elements of type [T].
 * It applies the [transform] function to each element in the list and returns a Flow
 * that emits a list of transformed elements of type [R].
 *
 * @param T the type of the elements in the original list.
 * @param R the type of the elements in the transformed list.
 * @param transform a function that takes an element of type [T] and returns an element of type [R].
 * @return a [Flow] that emits [list][List] of transformed elements of type [R].
 */
inline fun <T, R> Flow<List<T>>.mapList(
    crossinline transform: (value: T) -> R
): Flow<List<R>> = this.map { list -> list.map(transform) }

/**
 * Transforms each element in a [PagingData] stream emitted by a [Flow] using the provided [transform] function,
 * and caches the resulting [Flow] within the provided [coroutineScope].
 *
 * This function is an inline extension for a [Flow] that emits [PagingData] containing elements of type [T].
 * It applies the [transform] function to each element within the [PagingData] and returns a [Flow]
 * that emits [PagingData] containing elements of type [R]. Additionally, the resulting [Flow] is cached
 * in the provided [coroutineScope].
 *
 * @param T the type of the elements in the original [PagingData].
 * @param R the type of the elements in the transformed [PagingData].
 * @param coroutineScope the [CoroutineScope] in which the [Flow] will be cached.
 * @param transform a function that takes an element of type [T] and returns an element of type [R].
 * @return a [Flow] that emits transformed [PagingData] containing elements of type [R], cached in the provided [coroutineScope].
 */
inline fun <T : Any, R : Any> Flow<PagingData<T>>.mapPaging(
    coroutineScope: CoroutineScope,
    crossinline transform: (value: T) -> R
): Flow<PagingData<R>> = this.map { value: PagingData<T> ->
    value.map {
        it.let(transform)
    }
}.cachedIn(coroutineScope)