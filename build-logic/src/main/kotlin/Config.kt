import org.gradle.api.JavaVersion

object Config {

    const val jvmToolchain: Int = 17
    val javaVersion: JavaVersion = JavaVersion.VERSION_17
    const val jvmTarget: String = jvmToolchain.toString()
    const val compileSdk: Int = 34
    const val minSdk: Int = 29
    const val targetSdk: Int = 34
}