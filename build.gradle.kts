plugins {
    alias(libs.plugins.android.application) apply false
    kotlin("android") version libs.versions.kotlin apply false
    kotlin("plugin.serialization") version libs.versions.kotlin apply false

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs) apply false

    // Hilt
    alias(libs.plugins.hilt.android) apply false

    // KSP
    alias(libs.plugins.ksp) apply false
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}