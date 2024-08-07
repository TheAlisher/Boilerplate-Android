import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.library")
    kotlin("android")
}

configure<BaseExtension> {
    val libs = libs
    plugins {
        id(libs.plugKotlinxSerialization())
        id(libs.plugHiltAndroid())
        id(libs.plugKsp())
    }

    dependencies {
        implementation(libs.libKotlinXSerialization())
        implementation(libs.libHiltAndroid())
        ksp(libs.libHiltCompiler())
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

        // Enable Context Receivers
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    jvmToolchain(jdkVersion = LangOptions.jvmToolchain)

    // Enable Explicit Backing Fields
    sourceSets.all {
        // languageSettings.enableLanguageFeature("ExplicitBackingFields")
    }
}