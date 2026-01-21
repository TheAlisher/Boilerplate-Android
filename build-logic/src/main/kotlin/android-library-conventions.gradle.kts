import com.android.build.api.dsl.LibraryExtension

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

    namespace = AndroidConfig.APPLICATION_ID + ".${project.name}"

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
}

dependencies {

    // Kotlinx Serialization
    implementation(libsWorkaround.kotlinx.serialization)

    // Hilt
    implementation(libsWorkaround.hilt.android)
    kspWorkaround(libsWorkaround.hilt.compiler)
}