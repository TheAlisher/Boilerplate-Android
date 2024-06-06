import com.android.build.gradle.BaseExtension

plugins {
    id("android-library-conventions")
}

configure<BaseExtension> {
    val libs = libs

    plugins {
        id(libs.plugNavSafeArgs())
        id(libs.plugHiltAndroid())
    }

    dependencies {
        "implementation"(libs.libHiltAndroid())
        "ksp"(libs.libHiltCompiler())
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