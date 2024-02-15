import extensions.*

plugins {
    id("com.android.application")
    kotlin("android")
}

kotlin {
    jvmToolchain(jvmToolchain)
}

android {
    namespace = Namespaces.app
    compileSdk = compileSdk

    defaultConfig {
        applicationId = "com.alish.boilerplate"
        minSdk = minSdk
        targetSdk = targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    kotlinOptions {
        jvmTarget = jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}