plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    id(Plugins.KSP.ksp) version Versions.KSP
}

android {
    compileSdk = GradleConfig.compileSdk

    defaultConfig {
        minSdk = GradleConfig.minSdk
        targetSdk = GradleConfig.targetSdk
    }

    buildTypes {
        getByName(GradleConfig.release) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://example.com/\"")
        }

        getByName(GradleConfig.debug) {
            buildConfigField("String", "BASE_URL", "\"https://example.com.debug/\"")
        }
    }
    compileOptions {
        sourceCompatibility = GradleConfig.compileOptions
        targetCompatibility = GradleConfig.compileOptions
    }
    kotlinOptions {
        jvmTarget = GradleConfig.kotlinOptions
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