plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(kotlinLibs.plugins.composeMultiplatform) apply false
    alias(kotlinLibs.plugins.composeCompiler) apply false
    alias(kotlinLibs.plugins.kotlinMultiplatform) apply false
    kotlin("plugin.serialization") version "2.0.20" apply false
}