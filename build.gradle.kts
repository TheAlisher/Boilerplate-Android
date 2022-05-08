plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    kotlin("android") version "1.6.21" apply false

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs) version Versions.navigation apply false

    // Hilt
    id(Plugins.Hilt.plugin) version Versions.hilt apply false
}