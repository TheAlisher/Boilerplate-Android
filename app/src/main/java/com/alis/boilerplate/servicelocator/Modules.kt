package com.alis.boilerplate.servicelocator

import com.alis.boilerplate.data.PreferencesHelper
import com.alis.boilerplate.data.network.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val viewModelModule = module {

}

val repositoryModule = module {

}

val localModule = module {
    single { PreferencesHelper(androidContext()) }
}

val networkModule = module {
    single { RetrofitClient().provideAPI() }
}