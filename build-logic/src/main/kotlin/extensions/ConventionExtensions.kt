package extensions

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.config: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal val VersionCatalog.jvmToolchain: Int
    get() = 17

internal val VersionCatalog.javaVersion: JavaVersion
    get() = JavaVersion.VERSION_17

internal val VersionCatalog.jvmTarget: String
    get() = jvmToolchain.toString()

internal val VersionCatalog.compileSdk: Int
    get() = 34

internal val VersionCatalog.minSdk: Int
    get() = 29

internal val VersionCatalog.targetSdk: Int
    get() = 34

internal object Namespaces {

    const val app = "com.alish.boilerplate"
    const val data = "${app}.data"
}