import com.android.build.gradle.BaseExtension

plugins {
    id("android-library-conventions")
}

configure<BaseExtension> {
    plugins {

        // Navigation Safe Args
        alias(libsWorkaround.plugins.androidx.navigation.safeArgs)
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