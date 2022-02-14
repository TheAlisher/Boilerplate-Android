plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")

    // Navigation Safe Args
    id("androidx.navigation.safeargs.kotlin")

    // Hilt
    id("dagger.hilt.android.plugin")

    // Easylauncher
    id("com.starter.easylauncher") version "5.0.0"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.alish.boilerplate"
        minSdk = 23
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {

        // View Binding
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // UI Components
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3")

    // Core
    implementation(Dependencies.Core.core)

    // Activity
    implementation(Dependencies.Activity.activity)

    // Fragment
    implementation(Dependencies.Fragment.fragment)

    // Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.viewModel)

    // Navigation
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    // Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.kapt)
}

easylauncher {

    buildTypes {
        create("debug") {
            filters(customRibbon(ribbonColor = "#FF6200EE", textSizeRatio = 0.150F))
        }
    }
}