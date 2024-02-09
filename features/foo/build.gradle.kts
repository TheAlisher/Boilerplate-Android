import extensions.Namespaces

plugins {
    id(Plugins.Conventions.androidFeature)
}

android {
    namespace = Namespaces.featureFoo
}