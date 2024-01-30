plugins {
    id(Plugins.Conventions.featureData)
}

dependencies {

    implementation(project(":features:baz:domain"))
}