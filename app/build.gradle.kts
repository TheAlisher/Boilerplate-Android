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
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-RC")

    // Core
    implementation("androidx.core:core-ktx:1.7.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.4.0")

    // Material Design Components
    implementation("com.google.android.material:material:1.4.0")

    // UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    // Activity
    val activityVersion = "1.4.0"
    implementation("androidx.activity:activity-ktx:$activityVersion")

    // Fragment
    val fragmentVersion = "1.4.0"
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:${Dependencies.Versions.nav}")
    implementation("androidx.navigation:navigation-ui-ktx:${Dependencies.Versions.nav}")

    // Lifecycle
    val lifecycleVersion = "2.4.0"

    // | for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // Retrofit 2
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    // | Gson
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:4.9.0")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Room
    val roomVersion = "2.3.0"
    implementation("androidx.room:room-runtime:$roomVersion")
    // | Kapt
    kapt("androidx.room:room-compiler:$roomVersion")
    // | optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Dependencies.Versions.hilt}")
    // | Kapt
    kapt("com.google.dagger:hilt-compiler:${Dependencies.Versions.hilt}")
    // | Extensions
    val hiltExtensionsVersion = "1.3.0-RC1"
    implementation("it.czerwinski.android.hilt:hilt-extensions:$hiltExtensionsVersion")
    kapt("it.czerwinski.android.hilt:hilt-processor:$hiltExtensionsVersion")

    // Paging 3
    val pagingVersion = "3.1.0"
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")

    // ViewBindingPropertyDelegate
    // | kirich1409 | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3")
    // | yogacp
    implementation("com.github.yogacp:android-viewbinding:1.0.3")
}