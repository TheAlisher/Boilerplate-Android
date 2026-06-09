import com.android.build.api.dsl.LibraryExtension
import kotlin.text.replace

plugins {
    id("com.android.library")
}

extensions.configure<LibraryExtension> {

    plugins {

        // Kotlinx Serialization
        alias(libsWorkaround.plugins.kotlinx.serialization)

        // Hilt
        alias(libsWorkaround.plugins.hilt.android)

        // KSP
        alias(libsWorkaround.plugins.ksp)
    }

    namespace = AndroidConfig.APPLICATION_ID + ".${project.name.replace("-", ".")}"

    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
    }

    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    jvmToolchain(jdkVersion = LangOptions.JVM_TOOLCHAIN)

    // TODO: remove this after stable API – Stabled in Kotlin 2.4.0
    // Support for using explicit backing fields in IntelliJ IDEA without the
    // -Xexplicit-backing-fields compiler option will be available in 2026.1.4.
    compilerOptions {
        freeCompilerArgs.add("-Xexplicit-backing-fields")
    }
}

dependencies {

    // Kotlinx Serialization
    implementation(libsWorkaround.kotlinx.serialization)

    // Hilt
    implementation(libsWorkaround.hilt.android)
    kspWorkaround(libsWorkaround.hilt.compiler)
}