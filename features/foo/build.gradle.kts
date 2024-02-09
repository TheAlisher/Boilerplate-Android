import extensions.Namespaces

plugins {
    id(Plugins.Conventions.androidLibrary)
}

android {
    namespace = Namespaces.featureFoo
}

dependencies {

    implementation(project(":data"))
    implementation(project(":presentation"))
}