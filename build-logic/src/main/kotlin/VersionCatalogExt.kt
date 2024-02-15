import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

internal val jvmToolchain: Int
    get() = 17

internal val javaVersion: JavaVersion
    get() = JavaVersion.VERSION_17

internal val jvmTarget: String
    get() = jvmToolchain.toString()

internal val compileSdk: Int
    get() = 34

internal val minSdk: Int
    get() = 29

internal val targetSdk: Int
    get() = 34

/**
 * Workaround from this
 *
 * [article](https://proandroiddev.com/gradle-kotlin-convention-plugins-for-modularized-structure-shared-build-logic-e740e1f07e88)
 *
 * [github](https://github.com/uteke/gradle-kotlin-convention-plugins/blob/main/build-logic/src/main/kotlin/VersionCatalogExtensions.kt)
 */
internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

private fun VersionCatalog.findPluginOrThrow(name: String) = findPlugin(name).orElseThrow {
    NoSuchElementException("Plugin $name not found in version catalog")
}.get().pluginId

private fun VersionCatalog.findLibraryOrThrow(name: String) = findLibrary(name).orElseThrow {
    NoSuchElementException("Library $name not found in version catalog")
}

private fun VersionCatalog.findVersionOrThrow(name: String) = findVersion(name).orElseThrow {
    NoSuchElementException("Version $name not found in version catalog")
}.requiredVersion

// Hilt
internal val VersionCatalog.libHiltAndroid get() = findLibraryOrThrow("hilt-android")
internal val VersionCatalog.libHiltCompiler get() = findLibraryOrThrow("hilt-compiler")