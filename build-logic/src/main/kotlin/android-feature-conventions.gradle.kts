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
    implementation(project(":core:domain"))
    implementation(project(":core:presentation"))
}