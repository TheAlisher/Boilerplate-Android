import extensions.*

plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(jdkVersion = config.jvmToolchain)
}

android {
    namespace = Namespaces.data
    compileSdk = config.compileSdk

    defaultConfig {
        minSdk = config.minSdk
    }

    compileOptions {
        sourceCompatibility = config.javaVersion
        targetCompatibility = config.javaVersion
    }
    kotlinOptions {
        jvmTarget = config.jvmTarget
    }
    buildFeatures {
        buildConfig = true
    }
}