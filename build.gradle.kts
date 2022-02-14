plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    kotlin("android") version "1.6.10" apply false
}

buildscript {
    dependencies {

        // Navigation Safe Args
        classpath(Dependencies.Navigation.safeArgsGradlePlugin)

        // Hilt
        classpath(Dependencies.Hilt.androidGradlePlugin)
    }
}