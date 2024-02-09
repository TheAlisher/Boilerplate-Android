package com.alish.boilerplate.domain.core

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

/**
 * Simple wrapper for convenience of network requests in repositories
 *
 * @see Flow
 * @see Either
 * @see NetworkError
 */
typealias RemoteWrapper<T> = Flow<Either<NetworkError, T>>

/**
 * Simple wrapper for convenience of network paging requests in repositories
 *
 * @see Flow
 * @see PagingData
 */
typealias RemotePagingWrapper<T> = Flow<PagingData<T>>