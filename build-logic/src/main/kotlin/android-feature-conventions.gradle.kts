import com.android.build.gradle.BaseExtension

plugins {
    id("android-library-conventions")
}

configure<BaseExtension> {
    val libs = libs

    plugins {
        id(libs.plugNavSafeArgs())
    }
}

android {

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:presentation"))
}