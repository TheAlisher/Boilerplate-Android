package com.alish.boilerplate.bar.data.repository

import com.alish.boilerplate.data.core.base.BaseRepository
import com.alish.boilerplate.data.core.utils.onSuccess
import com.alish.boilerplate.bar.data.db.dao.BarDao
import com.alish.boilerplate.bar.data.network.apiservice.BarApiService
import com.alish.boilerplate.bar.domain.repository.BarRepository
import it.czerwinski.android.hilt.annotations.BoundTo
import javax.inject.Inject

@BoundTo(supertype = BarRepository::class)
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