import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

/**
 * Workaround for not access to Version Catalog in build-logic
 * [issue](https://github.com/gradle/gradle/issues/15383)
 *
 * Workaround from this
 * [article](https://proandroiddev.com/gradle-kotlin-convention-plugins-for-modularized-structure-shared-build-logic-e740e1f07e88)
 * [github](https://github.com/uteke/gradle-kotlin-convention-plugins/blob/main/build-logic/src/main/kotlin/VersionCatalogExtensions.kt)
 */
internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

/**
 * Workaround from
 * [nowinandroid](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidHiltConventionPlugin.kt)
 */
internal val DependencyHandlerScope.ksp get() = "ksp"

// Kotlin
internal fun VersionCatalog.plugKotlinxSerialization() = findPluginOrThrow("kotlinx-serialization")

// KSP
internal fun VersionCatalog.plugKsp() = findPluginOrThrow("ksp")

// Navigation
internal fun VersionCatalog.plugNavSafeArgs() = findPluginOrThrow("androidx-navigation-safeArgs")

// Hilt
internal fun VersionCatalog.plugHiltAndroid() = findPluginOrThrow("hilt-android")
internal fun VersionCatalog.libHiltAndroid() = findLibraryOrThrow("hilt-android")
internal fun VersionCatalog.libHiltCompiler() = findLibraryOrThrow("hilt-compiler")

// – – –
private fun VersionCatalog.findPluginOrThrow(name: String) = findPlugin(name).orElseThrow {
    NoSuchElementException("Plugin $name not found in version catalog")
}.get().pluginId

private fun VersionCatalog.findLibraryOrThrow(name: String) = findLibrary(name).orElseThrow {
    NoSuchElementException("Library $name not found in version catalog")
}.get()