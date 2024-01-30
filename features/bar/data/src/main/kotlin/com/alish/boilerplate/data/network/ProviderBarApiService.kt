package com.alish.boilerplate.data.network

import com.alish.boilerplate.data.network.apiservice.BarApiService
import com.alish.boilerplate.data.remote.client.NetworkClient
import javax.inject.Inject

class ProviderBarApiService @Inject constructor(
    private val networkClient: NetworkClient,
) {
    operator fun invoke(): BarApiService = networkClient.provideRetrofit.create(
        BarApiService::class.java
    )
}