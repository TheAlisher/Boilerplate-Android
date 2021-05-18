package com.alish.boilerplate.data.repositories

import androidx.lifecycle.liveData
import com.alish.boilerplate.data.network.resource.Resource
import com.alish.boilerplate.data.network.retrofit.apiservices.FooApiService
import kotlinx.coroutines.Dispatchers

class RequestRepository(
    private val service: FooApiService
) {

    fun fetchFoo() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = service.fetchFoo()))
        } catch (exception: Exception) {
            emit(
                Resource.Error(
                    data = null, message = exception.localizedMessage ?: "Error Occurred!",
                )
            )
        }
    }
}