plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName(AndroidConfig.debug) {
        }
    }

    // View Binding
    buildFeatures.viewBinding = true
}

dependencies {

    implementation(project(":core-domain"))
    implementation(project(":data"))

    // Kotlin
    api(Libraries.Coroutines.android)

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
}