plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(17)
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 29
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://boilerplate.com/\"")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://dev.boilerplate.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}