plugins {
    id("com.android.library")
    kotlin("android")
}

kotlin {
    jvmToolchain(17)
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}