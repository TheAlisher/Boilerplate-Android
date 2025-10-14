import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.application")
    kotlin("android")
}

configure<BaseExtension> {
    val libs = libsWorkaround

    plugins {
        id(libs.plugHiltAndroid())
        id(libs.plugKsp())
    }

    dependencies {
        implementation(libs.libHiltAndroid())
        kspWorkaround(libs.libHiltCompiler())
    }
}

android {
    namespace = AndroidConfig.applicationId

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = LangOptions.javaVersion
        targetCompatibility = LangOptions.javaVersion
    }

    buildFeatures {
        viewBinding = true
    }
}

kotlin {
    jvmToolchain(LangOptions.jvmToolchain)
}

dependencies {

    implementation(project(":core:presentation"))
}