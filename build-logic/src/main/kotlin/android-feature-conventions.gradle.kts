import com.android.build.gradle.BaseExtension

plugins {
    id("android-library-conventions")
}

configure<BaseExtension> {
    val libs = libsWorkaround

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

    implementation(projectsWorkaround.core.data)
    implementation(projectsWorkaround.core.presentation)
}