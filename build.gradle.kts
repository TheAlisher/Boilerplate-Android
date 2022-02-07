plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    kotlin("android") version "1.6.10" apply false
}

buildscript {
    dependencies {
        // Navigation Safe Args
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.Versions.nav}")

        // Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Versions.hilt}")
    }
}