package com.alish.boilerplate.domain.usecase

import com.alish.boilerplate.domain.repository.BarRepository
import javax.inject.Inject

class FetchBarUseCase @Inject constructor(
    private val repository: BarRepository
) {
    operator fun invoke() = repository.fetchBar()
}