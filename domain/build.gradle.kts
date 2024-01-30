plugins {
    kotlin(Plugins.Kotlin.jvm)
}

kotlin {
    jvmToolchain(Options.jvmToolchain)
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

    // Paging
    api(Libraries.Paging.common)
}