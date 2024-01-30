plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
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