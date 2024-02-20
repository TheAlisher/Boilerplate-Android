plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = LangOptions.javaVersion
    targetCompatibility = LangOptions.javaVersion
}

kotlin {
    jvmToolchain(jdkVersion = LangOptions.jvmToolchain)
}