plugins {
    id("android-library-conventions")
}

android {
    namespace = "com.alish.boilerplate.data"
}

dependencies {

    implementation(project(":core:data"))
}