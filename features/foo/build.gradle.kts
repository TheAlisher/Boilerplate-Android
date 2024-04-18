plugins {
    alias(libs.plugins.conventions.androidFeature)

    // Kotlinx Serialization
    kotlin(libs.plugins.kotlinx.serialization.get().pluginId)

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs)

    // Hilt
    alias(libs.plugins.hilt.android)

    // KSP
    alias(libs.plugins.ksp)
}

android {
    namespace = Namespaces.featureFoo
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}