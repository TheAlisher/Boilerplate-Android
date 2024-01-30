package com.alish.boilerplate.domain.usecases

import com.alish.boilerplate.domain.repositories.BarRepository
import javax.inject.Inject

class FetchBarUseCase @Inject constructor(
    private val repository: BarRepository,
) {
    operator fun invoke() = repository.fetchBar()
}