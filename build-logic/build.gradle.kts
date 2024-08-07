plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {

    implementation(libs.kotlinGradlePlugin)
    implementation(libs.androidGradlePlugin)
}