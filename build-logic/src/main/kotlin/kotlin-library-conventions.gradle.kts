import extensions.*

plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(jdkVersion = jvmToolchain)
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}