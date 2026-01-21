package com.alish.boilerplate.bar.data.repository

import com.alish.boilerplate.core.data.base.BaseRepository
import com.alish.boilerplate.core.data.utils.onSuccess
import com.alish.boilerplate.bar.data.db.dao.BarDao
import com.alish.boilerplate.bar.data.network.apiservice.BarApiService
import com.alish.boilerplate.bar.domain.repository.BarRepository
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