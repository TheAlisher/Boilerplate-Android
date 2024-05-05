enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Boilerplate-Android"
includeBuild(
    "build-logic"
)
include(
    ":core",
    ":core:data",
    ":core:domain",
    ":core:presentation"
)
include(":app", ":features")
include(
    ":features:foo",
    ":features:bar"
)