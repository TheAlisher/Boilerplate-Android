import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.library")
    kotlin("android")
}

configure<BaseExtension> {
    val libs = libsWorkaround

    plugins {
        id(libs.plugKotlinxSerialization())
        id(libs.plugHiltAndroid())
        id(libs.plugKsp())
    }

    dependencies {
        implementation(libs.libKotlinXSerialization())
        implementation(libs.libHiltAndroid())
        kspWorkaround(libs.libHiltCompiler())
        implementation(libs.libHiltExtensions())
        kspWorkaround(libs.libHiltExtensionsProcessor())
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