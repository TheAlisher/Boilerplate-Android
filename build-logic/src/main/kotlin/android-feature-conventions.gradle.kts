plugins {
    id("android-library-conventions")
}

android {

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":presentation"))
}