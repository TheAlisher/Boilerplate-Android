plugins {
    id(Plugins.Conventions.featurePresentation)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

dependencies {

    implementation(project(":features:foo:domain"))

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)
}