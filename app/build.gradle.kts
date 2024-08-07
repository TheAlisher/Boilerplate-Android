plugins {
    alias(libs.plugins.convention.android.app)
}

dependencies {

    // Database
    implementation(projects.db)

    // Features
    implementation(projects.feature.foo)
    implementation(projects.feature.bar)
}