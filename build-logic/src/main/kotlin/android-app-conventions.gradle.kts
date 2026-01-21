import com.android.build.api.dsl.ApplicationExtension

plugins {
    id("com.android.application")
}

extensions.configure<ApplicationExtension> {
    plugins {

        // Hilt
        alias(libsWorkaround.plugins.hilt.android)

        // KSP
        alias(libsWorkaround.plugins.ksp)
    }

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

    // Hilt
    implementation(libsWorkaround.hilt.android)
    kspWorkaround(libsWorkaround.hilt.compiler)
}