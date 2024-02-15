plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(jdkVersion = jvmToolchain)
}

android {
    compileSdk = compileSdk

    defaultConfig {
        minSdk = minSdk
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    kotlinOptions {
        jvmTarget = jvmTarget
    }
    buildFeatures {
        buildConfig = true
    }
}