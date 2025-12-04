import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.application")
    kotlin("android")
}

configure<BaseExtension> {
    plugins {

        // Hilt
        alias(libsWorkaround.plugins.hilt.android)

        // KSP
        alias(libsWorkaround.plugins.ksp)
    }

    dependencies {

        // Hilt
        implementation(libsWorkaround.hilt.android)
        kspWorkaround(libsWorkaround.hilt.compiler)
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

    buildFeatures {
        viewBinding = true
    }
}

kotlin {
    jvmToolchain(LangOptions.jvmToolchain)
}

dependencies {

    implementation(projectsWorkaround.core.presentation)
}