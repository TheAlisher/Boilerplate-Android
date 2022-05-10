plugins {
    kotlin(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    // Javax Inject
    api(Libraries.Javax.inject)

    // Kotlin
    api(Libraries.Coroutines.core)
}