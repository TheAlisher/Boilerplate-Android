plugins {
    id("com.android.library")
    kotlin("android")
    id(Dependencies.Kotlin.ksp) version Dependencies.Kotlin.kspVersion
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))

    // Retrofit 2
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // OkHttp
    implementation(Dependencies.OkHttp.bom)
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.loggingInterceptor)

    // Room
    api(Dependencies.Room.runtime)
    ksp(Dependencies.Room.compiler)
    implementation(Dependencies.Room.supportKotlinExtensionsAndCoroutines)

    // Paging 3
    api(Dependencies.Paging.runtime)
}