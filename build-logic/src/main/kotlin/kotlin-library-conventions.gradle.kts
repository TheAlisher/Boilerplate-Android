plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}

kotlin {
    jvmToolchain(jdkVersion = Config.jvmToolchain)
}