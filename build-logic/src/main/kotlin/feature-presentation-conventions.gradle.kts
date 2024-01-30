plugins {
    id("android-library-conventions")
}

android {
    namespace = "com.alish.boilerplate.presentation"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core:presentation"))
}