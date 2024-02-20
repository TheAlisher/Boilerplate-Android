plugins {
    alias(libs.plugins.android.application) apply false
    kotlin("android") version libs.versions.kotlin apply false

    // Navigation Safe Args
    alias(libs.plugins.navigation.safeArgs) apply false

    // Hilt
    alias(libs.plugins.hilt.android) apply false

    // KSP
    alias(libs.plugins.ksp) apply false
}