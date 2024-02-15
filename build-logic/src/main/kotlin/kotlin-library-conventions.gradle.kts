plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(jdkVersion = Config.jvmToolchain)
}

java {
    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}