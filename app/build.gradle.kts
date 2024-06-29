plugins {
    id(Conventions.androidApp)
}

dependencies {

    // Room
    ksp(libs.androidx.room.compiler)

    // Features
    implementation(projects.feature.foo)
    implementation(projects.feature.bar)
}