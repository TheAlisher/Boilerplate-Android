plugins {
    id(Conventions.androidLibrary)
}

android {
    namespace = Namespaces.presentation
}

dependencies {

    implementation(project(":domain"))

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