package com.alish.boilerplate.data.network

import com.alish.boilerplate.data.network.apiservice.BazApiService
import com.alish.boilerplate.data.remote.client.NetworkClient
import javax.inject.Inject

class ProviderBazApiService @Inject constructor(
    private val networkClient: NetworkClient,
) {
    operator fun invoke(): BazApiService = networkClient.provideRetrofit.create(
        BazApiService::class.java
    )
}