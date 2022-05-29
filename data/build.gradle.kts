plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    id(Plugins.KSP.ksp) version Versions.KSP
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://example.com/\"")
        }

        getByName(AndroidConfig.debug) {
            buildConfigField("String", "BASE_URL", "\"https://example.com.debug/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(":domain"))

    // Retrofit 2
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.converterGson)

    // OkHttp
    implementation(Libraries.OkHttp.bom)
    implementation(Libraries.OkHttp.okHttp)
    implementation(Libraries.OkHttp.loggingInterceptor)

    // Room
    api(Libraries.Room.runtime)
    ksp(Libraries.Room.compiler)

    // Paging 3
    api(Libraries.Paging.runtime)
}