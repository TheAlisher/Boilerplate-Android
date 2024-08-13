import dev.iurysouza.modulegraph.Theme

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // Kotlinx Serialization
    alias(libs.plugins.kotlinx.serialization) apply false

    // Navigation Safe Args
    alias(libs.plugins.androidx.navigation.safeArgs) apply false

    // Hilt
    alias(libs.plugins.hilt.android) apply false

    // KSP
    alias(libs.plugins.ksp) apply false

    // Module Graph
    id("dev.iurysouza.modulegraph") version "0.10.0"
}

moduleGraphConfig {
    readmePath.set("./GRAPH.md")
    heading = "### Module Graph"
    setStyleByModuleType.set(true)
    rootModulesRegex.set(".*app.*")
    theme.set(Theme.DARK)
}