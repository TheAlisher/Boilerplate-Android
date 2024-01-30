plugins {
    id(Plugins.Conventions.androidApp)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.android)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.app
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:presentation"))

    // Hilt
    implementation(Libraries.Hilt.android)
    ksp(Libraries.Hilt.compiler)

    implementation(project(":features:foo:data"))
    implementation(project(":features:foo:domain"))
    implementation(project(":features:foo:presentation"))

    implementation(project(":features:bar:data"))
    implementation(project(":features:bar:domain"))
    implementation(project(":features:bar:presentation"))

    implementation(project(":features:baz:data"))
    implementation(project(":features:baz:domain"))
    implementation(project(":features:baz:presentation"))
}