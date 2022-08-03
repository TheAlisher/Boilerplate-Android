plugins {
    kotlin(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = Options.compileOptions
    targetCompatibility = Options.compileOptions
}

dependencies {

    // Javax Inject
    api(Libraries.Javax.inject)

    // Kotlin
    api(Libraries.Coroutines.core)

    implementation(Libraries.Paging.common)
}