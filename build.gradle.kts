plugins {
    alias(libs.plugins.dependencyanalysis)
}
buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.aboutlibraries.plugin)
    }
}