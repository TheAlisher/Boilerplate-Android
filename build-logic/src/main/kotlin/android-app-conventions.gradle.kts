import extensions.*

plugins {
    id("com.android.application")
    kotlin("android")
}

kotlin {
    jvmToolchain(config.jvmToolchain)
}

android {
    namespace = Namespaces.app
    compileSdk = config.compileSdk

    defaultConfig {
        applicationId = "com.alish.boilerplate"
        minSdk = config.minSdk
        targetSdk = config.targetSdk
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
        sourceCompatibility = config.javaVersion
        targetCompatibility = config.javaVersion
    }
    kotlinOptions {
        jvmTarget = config.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}