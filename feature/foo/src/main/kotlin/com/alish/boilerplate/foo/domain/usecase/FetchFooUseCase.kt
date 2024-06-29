package com.alish.boilerplate.foo.domain.usecase

import com.alish.boilerplate.foo.domain.repository.FooRepository
import javax.inject.Inject

class FetchFooUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.fetchFoo()
}