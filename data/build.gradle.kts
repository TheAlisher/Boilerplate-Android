plugins {
    id("com.android.library")
    kotlin("android")
    id(Dependencies.Kotlin.ksp) version Dependencies.Kotlin.kspVersion
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

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
    implementation(Dependencies.Retrofit2.retrofit)
    implementation(Dependencies.Retrofit2.converterGson)

    // OkHttp
    implementation(Dependencies.OkHttp3.bom)
    implementation(Dependencies.OkHttp3.okHttp)
    implementation(Dependencies.OkHttp3.loggingInterceptor)

    // Room
    api(Dependencies.Room.runtime)
    ksp(Dependencies.Room.compiler)
    implementation(Dependencies.Room.supportKotlinExtensionsAndCoroutines)

    // Paging 3
    api(Dependencies.Paging3.runtime)
}