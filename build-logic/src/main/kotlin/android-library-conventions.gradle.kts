import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.library")
    kotlin("android")
}

configure<BaseExtension> {
    plugins {

        // Kotlinx Serialization
        alias(libsWorkaround.plugins.kotlinx.serialization)

        // Hilt
        alias(libsWorkaround.plugins.hilt.android)

        // KSP
        alias(libsWorkaround.plugins.ksp)
    }

    dependencies {

        // Kotlinx Serialization
        implementation(libsWorkaround.kotlinx.serialization)

        // Hilt
        implementation(libsWorkaround.hilt.android)
        kspWorkaround(libsWorkaround.hilt.compiler)

        // Hilt extensions
        implementation(libsWorkaround.hilt.extensions)
        kspWorkaround(libsWorkaround.hilt.extensions.processor)
    }
}

android {
    namespace = AndroidConfig.applicationId + ".${project.name}"

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    compileOptions {
        sourceCompatibility = LangOptions.javaVersion
        targetCompatibility = LangOptions.javaVersion
    }

    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    jvmToolchain(jdkVersion = LangOptions.jvmToolchain)
}