plugins {
    alias(libs.plugins.convention.android.feature)
}

dependencies {

    // Room
    ksp(libs.androidx.room.compiler)

    // Modules
    implementation(projects.feature.foo)
    implementation(projects.feature.bar)
}