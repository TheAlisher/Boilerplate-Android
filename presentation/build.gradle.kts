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

    api(project(":domain"))

    // Kotlin
    api(Libraries.Coroutines.android)

    // UI Components
    api(Libraries.UIComponents.material)
    api(Libraries.UIComponents.constraintLayout)
    api(Libraries.UIComponents.vbpd)

    // Core
    api(Libraries.Core.core)
    api(Libraries.Core.splashscreen)

    // Activity
    api(Libraries.Activity.activity)

    // Fragment
    api(Libraries.Fragment.fragment)

    // Lifecycle
    api(Libraries.Lifecycle.viewModel)
    api(Libraries.Lifecycle.runtime)

    // Navigation
    api(Libraries.Navigation.fragment)
    api(Libraries.Navigation.ui)

    // Paging
    api(Libraries.Paging.runtime)
}