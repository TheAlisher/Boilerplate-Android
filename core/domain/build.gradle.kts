plugins {
    alias(libs.plugins.conventions.kotlinLibrary)
}

dependencies {

    // Javax Inject
    api(libs.javax.inject)

    // Kotlin
    api(libs.coroutines.core)

    // Paging
    api(libs.paging.common)
}