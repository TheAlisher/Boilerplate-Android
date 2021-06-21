package com.alish.boilerplate.servicelocator

import com.alish.boilerplate.data.db.room.RoomClient
import com.alish.boilerplate.data.network.retrofit.RetrofitClient
import com.alish.boilerplate.data.repositories.KoinRepository
import com.alish.boilerplate.ui.fragments.koin.KoinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { KoinViewModel(get()) }
}

val repositoriesModule = module {
    factory { KoinRepository(get(), get()) }
}

val databaseModule = module {
    single { RoomClient().provideRoom(androidContext()) }
    single { RoomClient().provideRoomFooDao(get()) }
}

val networkModule = module {
    single { RetrofitClient().provideFooApiService() }
}