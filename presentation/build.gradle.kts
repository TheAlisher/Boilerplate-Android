import extensions.Namespaces

plugins {
    id(Plugins.Conventions.androidLibrary)
}

android {
    namespace = Namespaces.presentation

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

}