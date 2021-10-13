package com.alish.boilerplate.domain.usecases.foo

import com.alish.boilerplate.data.repositories.FooRepositoryImpl

class FooPagingUseCase(
    private val repository: FooRepositoryImpl
) {
    operator fun invoke() = repository.fetchFooPaging()
}