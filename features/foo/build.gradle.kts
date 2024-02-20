plugins {
    alias(libs.plugins.conventions.androidFeature)

    // Navigation Safe Args
    alias(libs.plugins.navigation.safeArgs)

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