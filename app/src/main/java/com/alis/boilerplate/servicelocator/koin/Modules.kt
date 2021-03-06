package com.alis.boilerplate.servicelocator.koin

import com.alis.boilerplate.data.db.room.RoomClient
import com.alis.boilerplate.data.network.retrofit.RetrofitClient
import com.alis.boilerplate.data.repositories.KoinRepository
import com.alis.boilerplate.ui.fragments.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
}

val repositoriesModule = module {
    factory { KoinRepository(get()) }
}

val localModule = module {
    single { RoomClient().provideRoom(androidContext()) }
    single { RoomClient().provideDao(get()) }
}

val networkModule = module {
    single { RetrofitClient().provideAPI() }
}