plugins {
    id(Conventions.androidLibrary)

    // KSP
    id(Plugins.KSP.ksp)
}

android {
    namespace = Namespaces.data
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