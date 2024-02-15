import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.config: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

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

object Namespaces {

    const val app = "com.alish.boilerplate"
    const val data = "$app.data"
    const val presentation = "$app.presentation"

    private const val feature = "$app.feature"
    const val featureFoo = "$feature.foo"
}