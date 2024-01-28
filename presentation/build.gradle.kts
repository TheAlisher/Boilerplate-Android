plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
}

android {
    namespace = Namespaces.presentation
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Options.compileOptions
        targetCompatibility = Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(project(":domain"))

    // Kotlin
    api(Libraries.Coroutines.android)

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