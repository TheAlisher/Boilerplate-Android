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
    namespace = AndroidConfig.APPLICATION_ID

    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
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
    jvmToolchain(LangOptions.JVM_TOOLCHAIN)
}

dependencies {

    implementation(projectsWorkaround.core.presentation)
}