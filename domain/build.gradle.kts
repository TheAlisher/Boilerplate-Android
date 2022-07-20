plugins {
    kotlin(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = GradleConfig.compileOptions
    targetCompatibility = GradleConfig.compileOptions
}

dependencies {

    // Javax Inject
    api(Libraries.Javax.inject)

    // Kotlin
    api(Libraries.Coroutines.core)
}