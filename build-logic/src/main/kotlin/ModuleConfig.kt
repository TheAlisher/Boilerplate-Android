import org.gradle.api.JavaVersion

object LangOptions {

    const val jvmToolchain: Int = 17
    val javaVersion: JavaVersion = JavaVersion.VERSION_17
    const val jvmTarget: String = jvmToolchain.toString()
}

object AndroidConfig {

    const val applicationId = "com.alish.boilerplate"
    const val compileSdk: Int = 34
    const val minSdk: Int = 29
    const val targetSdk: Int = 34
}

object Namespaces {

    const val app = AndroidConfig.applicationId
    const val data = "$app.data"
    const val presentation = "$app.presentation"

    private const val feature = "$app.feature"
    const val featureFoo = "$feature.foo"
    const val featureBar = "$feature.bar"
}