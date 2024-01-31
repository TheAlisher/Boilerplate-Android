import extensions.Namespaces

plugins {
    id(Plugins.Conventions.androidLibrary)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)
}

android {
    namespace = Namespaces.presentation

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":domain"))

    // Kotlin
    implementation(Libraries.Coroutines.android)

    // UI Components
    implementation(Libraries.UIComponents.material)
    implementation(Libraries.UIComponents.constraintLayout)
    implementation(Libraries.UIComponents.vbpd)

    // Core
    implementation(Libraries.Core.core)
    implementation(Libraries.Core.splashscreen)

    // Activity
    implementation(Libraries.Activity.activity)

    // Fragment
    implementation(Libraries.Fragment.fragment)

    // Lifecycle
    implementation(Libraries.Lifecycle.viewModel)
    implementation(Libraries.Lifecycle.runtime)

    // Navigation
    implementation(Libraries.Navigation.fragment)
    implementation(Libraries.Navigation.ui)

    // Paging
    implementation(Libraries.Paging.runtime)
}