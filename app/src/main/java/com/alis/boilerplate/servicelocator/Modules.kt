package com.alis.boilerplate.servicelocator

import com.alis.boilerplate.data.db.room.RoomClient
import com.alis.boilerplate.data.network.ktor.FooRequests
import com.alis.boilerplate.data.network.ktor.KtorClient
import com.alis.boilerplate.data.network.retrofit.RetrofitClient
import com.alis.boilerplate.data.repositories.KoinRepository
import com.alis.boilerplate.ui.fragments.koin.KoinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { KoinViewModel(get()) }
}

val repositoriesModule = module {
    factory { KoinRepository(get(), get(), get()) }
}

val localModule = module {
    single { RoomClient().provideRoom(androidContext()) }
    single { RoomClient().provideRoomDao(get()) }
}

val networkModule = module {
    single { RetrofitClient().provideFooAPI() }
    single { FooRequests(KtorClient().provideKtor()) }
}