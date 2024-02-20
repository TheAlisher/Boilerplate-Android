plugins {
    alias(libs.plugins.conventions.androidLibrary)
}

android {
    namespace = Namespaces.presentation

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    api(project(":core:domain"))

    // Kotlin
    api(libs.coroutines.android)

    // UI Components
    api(libs.android.material)
    api(libs.android.constraintLayout)
    api(libs.android.vbpd)

    // Core
    api(libs.android.core)
    api(libs.android.core.splashscreen)

    // Activity
    api(libs.android.activity)

    // Fragment
    api(libs.android.fragment)

    // Lifecycle
    api(libs.lifecycle.viewModel)
    api(libs.lifecycle.runtime)

    // Navigation
    api(libs.navigation.fragment)
    api(libs.navigation.ui)

    // Paging
    api(libs.paging.runtime)
}