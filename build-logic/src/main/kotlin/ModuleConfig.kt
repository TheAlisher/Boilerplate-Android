import org.gradle.api.JavaVersion

object LangOptions {

    const val jvmToolchain: Int = 17
    val javaVersion: JavaVersion = JavaVersion.VERSION_17
    const val jvmTarget: String = jvmToolchain.toString()
}

object AndroidConfig {

    const val applicationId = "com.alish.boilerplate"
    const val compileSdk: Int = 35
    const val minSdk: Int = 29
    const val targetSdk: Int = 35
    const val versionCode = 1
    const val versionName = "1.0"

    const val PROD_BASE_URL = "\"https://boilerplate.com/\""
    const val DEV_BASE_URL = "\"https://dev.boilerplate.com/\""
}