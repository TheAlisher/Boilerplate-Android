package com.alish.boilerplate.data.repository

import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.core.utils.onSuccess
import com.alish.boilerplate.data.db.dao.BarDao
import com.alish.boilerplate.data.network.apiservice.BarApiService
import com.alish.boilerplate.domain.repository.BarRepository
import javax.inject.Inject

class BarRepositoryImpl @Inject constructor(
    private val service: BarApiService,
    private val dao: BarDao
): BaseRepository(), BarRepository {

    override fun fetchBar() = doNetworkRequestWithMapping {
        service.fetchBar().onSuccess { data ->
            dao.insertBar(data.toDBO())
        }
    }
}