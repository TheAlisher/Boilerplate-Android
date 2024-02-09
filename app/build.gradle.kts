plugins {
    id(Plugins.Conventions.androidApp)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

dependencies {

    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":features:foo"))

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)

    // Room
    implementation(Libraries.Room.runtime)
    ksp(Libraries.Room.compiler)
    implementation(Libraries.Room.ktx)
}