plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(jdkVersion = Config.jvmToolchain)
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = minSdk
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        buildConfig = true
    }
}