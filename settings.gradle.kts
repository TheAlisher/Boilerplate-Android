pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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
include(
    ":app",
    ":core",
    ":features",
)

include(
    ":core:data",
    ":core:domain",
    ":core:presentation",
)

include(
    ":features:foo",
    ":features:foo:data",
    ":features:foo:domain",
    ":features:foo:presentation",
)

include(
    ":features:bar",
    ":features:bar:data",
    ":features:bar:domain",
    ":features:bar:presentation"
)

include(
    ":features:baz",
    ":features:baz:data",
    ":features:baz:domain",
    ":features:baz:presentation"
)