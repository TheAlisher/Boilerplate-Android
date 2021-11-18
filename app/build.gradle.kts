plugins {
    id("com.android.application")
    id("kotlin-android")

    // Kapt
    id("kotlin-kapt")

    // Navigation Safe Args
    id("androidx.navigation.safeargs.kotlin")

    // Hilt
    id("dagger.hilt.android.plugin")
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
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    // Kotlin
    // | Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    // Core
    implementation("androidx.core:core-ktx:1.7.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.4.0")

    // Material Design Components
    implementation("com.google.android.material:material:1.4.0")

    // UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")

    // Activity
    val activity_version = "1.4.0"
    implementation("androidx.activity:activity-ktx:$activity_version")

    // Fragment
    val fragment_version = "1.4.0"
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:${Dependencies.Versions.nav}")
    implementation("androidx.navigation:navigation-ui-ktx:${Dependencies.Versions.nav}")

    // Lifecycle
    val lifecycle_version = "2.4.0"
    // | for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // | for LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    // Retrofit 2
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    // | Gson
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:4.9.0")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Room
    val room_version = "2.3.0"
    implementation("androidx.room:room-runtime:$room_version")
    // | Kapt
    kapt("androidx.room:room-compiler:$room_version")
    // | optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Dependencies.Versions.hilt}")
    // | Kapt
    kapt("com.google.dagger:hilt-compiler:${Dependencies.Versions.hilt}")

    // Paging 3
    val paging_version = "3.0.1"
    implementation("androidx.paging:paging-runtime-ktx:$paging_version")

    // ViewBindingPropertyDelegate
    // | kirich1409 | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.2")
    // | yogacp
    implementation("com.github.yogacp:android-viewbinding:1.0.3")
}