plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)

    // Kotlin Symbol Processing
    id(Plugins.KSP.ksp) version Versions.KSP
}

android {
    namespace = Namespaces.data

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://boilerplate.com/\"")
        }

        getByName(AndroidConfig.debug) {
            buildConfigField("String", "BASE_URL", "\"https://dev.boilerplate.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = Options.compileOptions
        targetCompatibility = Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":domain"))

    // Retrofit
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.converterMoshi)

    // Moshi
    implementation(Libraries.Moshi.moshi)
    implementation(Libraries.Moshi.kotlin)

    // OkHttp
    implementation(Libraries.OkHttp.bom)
    implementation(Libraries.OkHttp.okHttp)
    implementation(Libraries.OkHttp.loggingInterceptor)

    // Room
    api(Libraries.Room.runtime)
    ksp(Libraries.Room.compiler)
    implementation(Libraries.Room.ktx)

    // Paging
    api(Libraries.Paging.runtime)
}