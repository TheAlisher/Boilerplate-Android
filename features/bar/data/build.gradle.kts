plugins {
    id(Plugins.Conventions.featureData)
}

dependencies {

    implementation(project(":features:bar:domain"))
}