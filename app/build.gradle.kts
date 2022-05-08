plugins {
    id(Plugins.AGP.application)
    kotlin("android")
    kotlin("kapt")

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.plugin)

    // Easylauncher
    id("com.starter.easylauncher") version "5.0.0"
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.alish.boilerplate"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // View Binding
    buildFeatures.viewBinding = true
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // Kotlin
    implementation(Libraries.Coroutines.android)

    // UI Components
    implementation(Libraries.UIComponents.material)
    implementation(Libraries.UIComponents.constraintLayout)
    implementation(Libraries.UIComponents.viewBindingPropertyDelegate)

    // Core
    implementation(Libraries.Core.core)

    // Activity
    implementation(Libraries.Activity.activity)

    // Fragment
    implementation(Libraries.Fragment.fragment)

    // Lifecycle
    implementation(Libraries.Lifecycle.runtime)
    implementation(Libraries.Lifecycle.viewModel)

    // Navigation
    implementation(Libraries.Navigation.fragment)
    implementation(Libraries.Navigation.ui)

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)
}

easylauncher {

    buildTypes {
        create("debug") {
            filters(customRibbon(ribbonColor = "#FF6200EE", textSizeRatio = 0.150F))
        }
    }
}