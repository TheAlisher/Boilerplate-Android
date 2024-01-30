plugins {
    id(Conventions.kotlinLibrary)
}

dependencies {

    // Javax Inject
    api(Libraries.Javax.inject)

    // Kotlin
    api(Libraries.Coroutines.core)

    // Paging
    api(Libraries.Paging.common)
}