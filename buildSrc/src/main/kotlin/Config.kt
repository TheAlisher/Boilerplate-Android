import org.gradle.api.JavaVersion

object AndroidConfig {

    const val compileSdk = 33
    const val minSdk = 29
    const val targetSdk = 33

    const val release = "release"
    const val debug = "debug"
}

object Namespaces {

    const val app = "com.alish.boilerplate"
    const val data = "com.alish.boilerplate.data"
}

object Options {

    val compileOptions = JavaVersion.VERSION_17
    const val kotlinOptions = "17"
}