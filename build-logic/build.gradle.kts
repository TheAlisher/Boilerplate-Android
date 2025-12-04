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

    // Workaround for libs
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}