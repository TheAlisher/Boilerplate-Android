plugins {
    id(Conventions.androidFeature)

    // Kotlinx Serialization
    alias(libs.plugins.kotlinx.serialization)

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs)

    // Hilt
    alias(libs.plugins.hilt.android)

    // KSP
    alias(libs.plugins.ksp)
}

android {
    namespace = Namespaces.featureBar
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}