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
}

dependencies {

    implementation(project(":core:domain"))

    // Retrofit
    api(Libraries.Retrofit.retrofit)
    api(Libraries.Retrofit.converterMoshi)

    // Moshi
    api(Libraries.Moshi.kotlin)
    api(Libraries.Moshi.adapters)
    api(Libraries.Moshi.codegen)

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