plugins {
    alias(libs.plugins.conventions.androidLibrary)
    kotlin("plugin.serialization")

    // KSP
    alias(libs.plugins.ksp)
}

android {
    namespace = Namespaces.data

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://boilerplate.com/\"")
        }

        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://dev.boilerplate.com/\"")
        }
    }
}

dependencies {

    implementation(project(":core:domain"))

    // Kotlin
    api(libs.kotlinx.serialization)

    // Retrofit
    api(libs.retrofit)
    api(libs.retrofit.converterMoshi)
    api(libs.retrofit.kotlinx.serialization.converter)

    // Moshi
    api(libs.moshi.kotlin)
    api(libs.moshi.adapters)
    api(libs.moshi.codegen)

    // OkHttp
    implementation(platform(libs.okHttp.bom))
    implementation(libs.okHttp)
    implementation(libs.okHttp.loggingInterceptor)

    // Room
    api(libs.room.runtime)
    ksp(libs.room.compiler)
    api(libs.room.ktx)

    // Security
    implementation(libs.security.crypto)
}