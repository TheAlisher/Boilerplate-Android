plugins {
    alias(libs.plugins.conventions.androidLibrary)

    // Kotlinx Serialization
    alias(libs.plugins.kotlinx.serialization)

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
    implementation(libs.retrofit.kotlinx.serialization.converter)

    // OkHttp
    implementation(platform(libs.okHttp.bom))
    implementation(libs.okHttp)
    implementation(libs.okHttp.loggingInterceptor)

    // Room
    api(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    api(libs.androidx.room.ktx)

    // Security
    implementation(libs.androidx.security.crypto)
}