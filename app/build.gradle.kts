plugins {
    id(Plugins.Conventions.androidApp)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:presentation"))
    implementation(project(":features:foo"))

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)

    // Room
    ksp(Libraries.Room.compiler)
}