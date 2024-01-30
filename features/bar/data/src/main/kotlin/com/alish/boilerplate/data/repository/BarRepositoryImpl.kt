package com.alish.boilerplate.data.repository

import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.network.apiservice.BarApiService
import com.alish.boilerplate.domain.repositories.BarRepository
import javax.inject.Inject

class BarRepositoryImpl @Inject constructor(
    private val service: BarApiService,
) : BaseRepository(), BarRepository {

    override fun fetchBar() = doNetworkRequestWithMapping {
        service.fetchBar()
    }
}