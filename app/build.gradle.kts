plugins {
    id(Conventions.androidApp)
}

dependencies {

    // Room
    ksp(libs.androidx.room.compiler)

    // Features
    implementation(projects.features.foo)
    implementation(projects.features.bar)
}