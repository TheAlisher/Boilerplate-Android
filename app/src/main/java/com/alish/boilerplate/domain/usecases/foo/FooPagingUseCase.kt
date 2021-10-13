package com.alish.boilerplate.domain.usecases.foo

import com.alish.boilerplate.data.repositories.FooRepositoryImpl
import javax.inject.Inject

class FooPagingUseCase @Inject constructor(
    private val repository: FooRepositoryImpl
) {
    operator fun invoke() = repository.fetchFooPaging()
}