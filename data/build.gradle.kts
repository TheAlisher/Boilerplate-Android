plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)

    // KSP
    id(Plugins.KSP.ksp)
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
    implementation(platform(Libraries.OkHttp.bom))
    implementation(Libraries.OkHttp.okHttp)
    implementation(Libraries.OkHttp.loggingInterceptor)

    // Room
    implementation(Libraries.Room.runtime)
    ksp(Libraries.Room.compiler)
    implementation(Libraries.Room.ktx)

    // Security
    implementation(Libraries.Security.crypto)
}