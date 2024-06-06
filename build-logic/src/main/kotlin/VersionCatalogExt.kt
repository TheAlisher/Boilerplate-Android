import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
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
