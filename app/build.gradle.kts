plugins {
    id(Plugins.Conventions.androidApp)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

dependencies {

    implementation(project(":features:foo"))

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)
}