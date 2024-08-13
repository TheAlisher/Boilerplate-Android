plugins {
    alias(libs.plugins.convention.android.library)
}

dependencies {

    // Data
    implementation(projects.core.data)

    // Room
    ksp(libs.androidx.room.compiler)

    // Feature
    implementation(projects.feature.foo)
    implementation(projects.feature.bar)
}