plugins {
    alias(libs.plugins.convention.android.app)
}

dependencies {

    // TODO: remove after Dagger Hilt update kotlin metadata version [if they update ;)]
    ksp("org.jetbrains.kotlin:kotlin-metadata-jvm:2.4.0")

    // Database
    implementation(projects.db)

    // Features
    implementation(projects.feature.foo)
    implementation(projects.feature.bar)
}