package com.alis.boilerplate.servicelocator

import com.alis.boilerplate.data.PreferencesHelper
import com.alis.boilerplate.data.network.RetrofitClient
import com.alis.boilerplate.data.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val viewModelModule = module {

}

val repositoryModule = module {
    factory { Repository(get()) }
}

val localModule = module {
    single { PreferencesHelper(androidContext()) }
}

val networkModule = module {
    single { RetrofitClient().provideAPI() }
}