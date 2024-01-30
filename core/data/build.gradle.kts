plugins {
    id(Plugins.Conventions.androidLibrary)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.data

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://boilerplate.com/\"")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://dev.boilerplate.com/\"")
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    api(project(":core:domain"))

    // Retrofit
    api(Libraries.Retrofit.retrofit)
    api(Libraries.Retrofit.converterMoshi)

    // Moshi
    implementation(Libraries.Moshi.moshi)
    implementation(Libraries.Moshi.kotlin)

    // OkHttp
    implementation(platform(Libraries.OkHttp.bom))
    implementation(Libraries.OkHttp.okHttp)
    implementation(Libraries.OkHttp.loggingInterceptor)

    // Room
    api(Libraries.Room.runtime)
    ksp(Libraries.Room.compiler)
    api(Libraries.Room.ktx)

    // Security
    implementation(Libraries.Security.crypto)
}