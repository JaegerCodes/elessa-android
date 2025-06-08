buildscript {
    dependencies {
        classpath(libs.elessa.convention)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
allprojects {
    repositories {
    }
    apply(plugin = "llamasoft.detekt")
}
plugins {
    //alias(core.plugins.android.application) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) version libs.versions.kspVersion.get() apply true
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}
