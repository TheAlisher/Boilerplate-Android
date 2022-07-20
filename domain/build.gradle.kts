plugins {
    kotlin(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = AndroidConfig.compileOptions
    targetCompatibility = AndroidConfig.compileOptions
}

dependencies {

    // Javax Inject
    api(Libraries.Javax.inject)

    // Kotlin
    api(Libraries.Coroutines.core)
}