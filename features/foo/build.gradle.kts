import extensions.Namespaces

plugins {
    id(Plugins.Conventions.androidFeature)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.featureFoo
}

dependencies {

    api(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)
}