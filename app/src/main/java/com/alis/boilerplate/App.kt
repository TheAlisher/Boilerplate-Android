package com.alis.boilerplate

import android.app.Application
import com.alis.boilerplate.servicelocator.localModule
import com.alis.boilerplate.servicelocator.networkModule
import com.alis.boilerplate.servicelocator.repositoryModule
import com.alis.boilerplate.servicelocator.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelModule, repositoryModule, localModule, networkModule)
        }
    }
}