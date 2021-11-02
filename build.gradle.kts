buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

        // Navigation Safe Args
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.Versions.nav}")

        // Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Versions.hilt}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}