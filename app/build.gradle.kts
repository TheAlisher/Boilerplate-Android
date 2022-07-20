plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.plugin)
}

android {
    compileSdk = GradleConfig.compileSdk

    defaultConfig {
        applicationId = "com.alish.boilerplate"
        minSdk = GradleConfig.minSdk
        targetSdk = GradleConfig.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName(GradleConfig.release) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(GradleConfig.debug) {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = GradleConfig.compileOptions
        targetCompatibility = GradleConfig.compileOptions
    }
    kotlinOptions {
        jvmTarget = GradleConfig.kotlinOptions
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
    implementation(Libraries.UIComponents.vbpd)

    // Core
    implementation(Libraries.Core.core)

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

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)
}