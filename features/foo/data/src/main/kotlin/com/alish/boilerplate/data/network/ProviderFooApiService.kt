package com.alish.boilerplate.data.network

import com.alish.boilerplate.data.network.apiservices.FooApiService
import com.alish.boilerplate.data.remote.client.NetworkClient
import javax.inject.Inject

class ProviderFooApiService @Inject constructor(
    private val networkClient: NetworkClient,
) {
    operator fun invoke(): FooApiService = networkClient.provideRetrofit.create(
        FooApiService::class.java
    )
}