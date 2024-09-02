plugins {
    alias(libs.plugins.convention.android.library)
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
    api(projects.core.domain)

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
}