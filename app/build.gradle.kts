plugins {
    id("com.android.application")
    id("kotlin-android")

    // Kapt
    id("kotlin-kapt")

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
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // Activity
    val activityVersion = "1.4.0"
    implementation("androidx.activity:activity-ktx:$activityVersion")

    // Fragment
    val fragmentVersion = "1.4.1"
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:${Dependencies.Versions.nav}")
    implementation("androidx.navigation:navigation-ui-ktx:${Dependencies.Versions.nav}")

    // Lifecycle
    val lifecycleVersion = "2.4.0"
    // | for Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    // | for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Dependencies.Versions.hilt}")
    // | Kapt
    kapt("com.google.dagger:hilt-compiler:${Dependencies.Versions.hilt}")

    // ViewBindingPropertyDelegate | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3")
}

easylauncher {

    buildTypes {
        create("debug") {
            filters(customRibbon(ribbonColor = "#FF6200EE", textSizeRatio = 0.150F))
        }
    }
}