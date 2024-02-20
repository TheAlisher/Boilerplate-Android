plugins {
    alias(libs.plugins.conventions.androidApp)

    // Hilt
    alias(libs.plugins.hilt.android)

    // KSP
    alias(libs.plugins.ksp)
}

android {
    namespace = Namespaces.app
}

dependencies {

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Room
    ksp(libs.room.compiler)

    // Features
    implementation(project(":features:foo"))
}