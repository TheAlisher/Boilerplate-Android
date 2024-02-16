plugins {
    id(Plugins.Conventions.androidApp)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.app
}

dependencies {

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)

    // Room
    ksp(Libraries.Room.compiler)

    // Features
    implementation(project(":features:foo"))
}