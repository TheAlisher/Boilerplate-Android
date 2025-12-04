import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.the

/**
 * Workaround for not access to Version Catalog in build-logic
 * [issue](https://github.com/gradle/gradle/issues/15383)
 *
 * Workaround from this
 * [article](https://proandroiddev.com/gradle-kotlin-convention-plugins-for-modularized-structure-shared-build-logic-e740e1f07e88)
 * [github](https://github.com/uteke/gradle-kotlin-convention-plugins/blob/main/build-logic/src/main/kotlin/VersionCatalogExtensions.kt)
 */
internal val Project.libsWorkaround get() = the<LibrariesForLibs>()

/**
 * Workaround from
 * [nowinandroid](https://github.com/android/nowinandroid/blob/main/build-logic/convention/src/main/kotlin/AndroidHiltConventionPlugin.kt)
 */
internal fun DependencyHandler.kspWorkaround(dependencyNotation: Any): Dependency? = add(
    "ksp", dependencyNotation
)