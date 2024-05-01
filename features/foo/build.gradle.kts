plugins {
    alias(libs.plugins.conventions.androidFeature)

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
    //TODO migrate from Namespaces to TYPESAFE_ACCESSORS namespace
    project.logger.debug("ANIME ${projects.features.foo.toString()}")

    namespace = Namespaces.featureFoo
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.extensions)
    ksp(libs.hilt.extensions.processor)
}