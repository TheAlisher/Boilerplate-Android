plugins {
    id("android-library-conventions")
}

android {

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:presentation"))

    // Hilt
    implementation(libs.libHiltAndroid)
    implementation(libs.libHiltCompiler)
}