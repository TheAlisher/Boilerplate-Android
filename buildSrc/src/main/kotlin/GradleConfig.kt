import org.gradle.api.JavaVersion

object GradleConfig {

    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32

    const val release = "release"
    const val debug = "debug"

    val compileOptions = JavaVersion.VERSION_11
    const val kotlinOptions = "11"
}