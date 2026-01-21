plugins {
    alias(libs.plugins.android.application) apply false

    // Kotlinx Serialization
    alias(libs.plugins.kotlinx.serialization) apply false

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs) apply false

    // Hilt
    alias(libs.plugins.hilt.android) apply false

    // KSP
    alias(libs.plugins.ksp) apply false
}