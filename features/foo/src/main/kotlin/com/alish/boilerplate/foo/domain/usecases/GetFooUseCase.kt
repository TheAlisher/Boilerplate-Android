package com.alish.boilerplate.foo.domain.usecases

import com.alish.boilerplate.foo.domain.repositories.FooRepository
import javax.inject.Inject

class GetFooUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.getFoo()
}