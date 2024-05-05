plugins {
    alias(libs.plugins.conventions.androidLibrary)

    // Kotlinx Serialization
    alias(libs.plugins.kotlinx.serialization)

    // Hilt
    alias(libs.plugins.hilt.android)

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