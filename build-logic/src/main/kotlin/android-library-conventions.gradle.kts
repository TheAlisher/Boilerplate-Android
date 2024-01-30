plugins {
    id("options-conventions")
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 29
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            buildConfigField("String", "BASE_URL", "\"https://boilerplate.com/\"")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://dev.boilerplate.com/\"")
        }
    }
    buildFeatures {
        buildConfig = true
    }
}