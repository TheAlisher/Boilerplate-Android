package com.alis.boilerplate.data.repositories

import com.alis.boilerplate.data.local.BoilerplateDao
import com.alis.boilerplate.data.network.ktor.KtorBoilerplateService
import com.alis.boilerplate.data.network.retrofit.RetrofitBoilerplateService
import javax.inject.Inject

class HiltRepository @Inject constructor(
    private val retrofitService: RetrofitBoilerplateService,
    private val ktorService: KtorBoilerplateService,
    private val boilerplateDao: BoilerplateDao
) {
    // …
}