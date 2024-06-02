plugins {
    id(Conventions.androidFeature)

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs)

    // Hilt
    alias(libs.plugins.hilt.android)
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}