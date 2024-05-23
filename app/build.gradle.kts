plugins {
    id(Conventions.androidApp)

    // Hilt
    alias(libs.plugins.hilt.android)

    // KSP
    alias(libs.plugins.ksp)
}

dependencies {

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Room
    ksp(libs.androidx.room.compiler)

    // Features
    implementation(projects.features.foo)
    implementation(projects.features.bar)
}