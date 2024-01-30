import extensions.*

plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(jdkVersion = config.jvmToolchain)
}

java {
    sourceCompatibility = config.javaVersion
    targetCompatibility = config.javaVersion
}