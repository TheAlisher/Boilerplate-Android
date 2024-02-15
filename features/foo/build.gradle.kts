plugins {
    id(Plugins.Conventions.androidFeature)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.featureFoo
}

dependencies {

    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)
}