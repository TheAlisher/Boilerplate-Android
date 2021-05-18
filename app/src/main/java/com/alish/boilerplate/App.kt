package com.alish.boilerplate

import android.app.Application
import com.alish.boilerplate.servicelocator.databaseModule
import com.alish.boilerplate.servicelocator.networkModule
import com.alish.boilerplate.servicelocator.repositoriesModule
import com.alish.boilerplate.servicelocator.viewModelsModule
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
            modules(viewModelsModule, repositoriesModule, databaseModule, networkModule)
        }
    }
}