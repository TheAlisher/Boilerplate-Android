plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {

    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
}