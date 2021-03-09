package com.alis.boilerplate

import android.app.Application
import com.alis.boilerplate.servicelocator.koin.localModule
import com.alis.boilerplate.servicelocator.koin.networkModule
import com.alis.boilerplate.servicelocator.koin.repositoriesModule
import com.alis.boilerplate.servicelocator.koin.viewModelsModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * for Hilt
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        /**
         * for Koin
         */
        startKoin {
            androidContext(this@App)
            modules(viewModelsModule, repositoriesModule, localModule, networkModule)
        }
    }
}