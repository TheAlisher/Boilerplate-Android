import com.android.build.gradle.BaseExtension

plugins {
    id("android-library-conventions")
}

configure<BaseExtension> {
    plugins {
        // androidx-navigation-safeArgs
        id("androidx.navigation.safeargs.kotlin")
        // hilt-android
        id("com.google.dagger.hilt.android")
    }
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