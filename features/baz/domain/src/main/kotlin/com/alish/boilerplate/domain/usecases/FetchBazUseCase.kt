package com.alish.boilerplate.domain.usecases

import com.alish.boilerplate.domain.repositories.BazRepository
import javax.inject.Inject

class FetchBazUseCase @Inject constructor(
    private val repository: BazRepository,
) {
    operator fun invoke() = repository.fetchBaz()
}