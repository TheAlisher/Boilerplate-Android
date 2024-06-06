import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.library")
    kotlin("android")
}

configure<BaseExtension> {
    val libs = libs
    plugins {
        id(libs.plugKotlinxSerialization())
        id(libs.plugKsp())
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
    kotlinOptions {
        jvmTarget = LangOptions.jvmTarget
    }
    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    jvmToolchain(jdkVersion = LangOptions.jvmToolchain)
}

// Enable Context Receivers
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}