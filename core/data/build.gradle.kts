plugins {
    id(Conventions.androidLibrary)

    // Hilt
    alias(libs.plugins.hilt.android)
}

android {
    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", AndroidConfig.PROD_BASE_URL)
        }

        getByName("debug") {
            buildConfigField("String", "BASE_URL", AndroidConfig.DEV_BASE_URL)
        }
    }
}

dependencies {

    // Modules
    implementation(projects.core.domain)

    // Kotlin
    api(libs.kotlinx.serialization)

    // Retrofit
    api(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)

    // OkHttp
    implementation(platform(libs.okHttp.bom))
    implementation(libs.okHttp)
    implementation(libs.okHttp.loggingInterceptor)

    // Room
    api(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    // Security
    implementation(libs.androidx.security.crypto)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}