package com.alish.boilerplate.data.repository

import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.network.apiservice.BazApiService
import com.alish.boilerplate.domain.repositories.BazRepository
import javax.inject.Inject

class BazRepositoryImpl @Inject constructor(
    private val service: BazApiService,
) : BaseRepository(), BazRepository {

    override fun fetchBaz() = doNetworkRequestWithMapping {
        service.fetchBaz()
    }
}