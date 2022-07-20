package com.alish.boilerplate.domain.usecases.foopaging

import com.alish.boilerplate.domain.repositories.FooRepository
import javax.inject.Inject

class FetchFooPagingUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.fetchFooPaging()
}