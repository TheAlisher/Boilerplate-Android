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

    // Core
    implementation("androidx.core:core-ktx:1.7.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.4.1")

    // Material Design Components
    implementation("com.google.android.material:material:1.5.0")

    // UI Components
    // | ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    // | ViewBindingPropertyDelegate | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3")

    // Activity
    val activityVersion = "1.4.0"
    implementation("androidx.activity:activity-ktx:$activityVersion")

    // Fragment
    val fragmentVersion = "1.4.1"
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

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