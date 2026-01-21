import com.android.build.api.dsl.LibraryExtension
import org.gradle.kotlin.dsl.configure

plugins {
    id("android-library-conventions")
}

extensions.configure<LibraryExtension> {
    plugins {

        // Navigation Safe Args
        alias(libsWorkaround.plugins.androidx.navigation.safeArgs)
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(projectsWorkaround.core.data)
    implementation(projectsWorkaround.core.presentation)
}