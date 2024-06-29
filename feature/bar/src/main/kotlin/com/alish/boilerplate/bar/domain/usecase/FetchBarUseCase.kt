package com.alish.boilerplate.bar.domain.usecase

import com.alish.boilerplate.bar.domain.repository.BarRepository
import javax.inject.Inject

class FetchBarUseCase @Inject constructor(
    private val repository: BarRepository
) {
    operator fun invoke() = repository.fetchBar()
}