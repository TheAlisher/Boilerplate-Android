plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(jdkVersion = 17)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}