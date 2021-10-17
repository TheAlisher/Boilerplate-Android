package com.alish.boilerplate.domain.usecases.foo

import com.alish.boilerplate.domain.repositories.FooRepository
import javax.inject.Inject

class FooPagingUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.fetchFooPaging()
}