plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Modules
    api(projects.core.domain)

    // Kotlin
    api(libs.kotlinx.coroutines.android)

    // UI Components
    api(libs.android.material)
    api(libs.androidx.constraintLayout)
    api(libs.viewbinding.propertydelegate)

    // Core
    api(libs.androidx.core)
    api(libs.androidx.core.splashscreen)

    // Activity
    api(libs.androidx.activity)

    // Fragment
    api(libs.androidx.fragment)

    // Lifecycle
    api(libs.androidx.lifecycle.viewModel)
    api(libs.androidx.lifecycle.runtime)

    // Navigation
    api(libs.androidx.navigation.fragment)
    api(libs.androidx.navigation.ui)

    // Paging
    api(libs.androidx.paging.runtime)
}