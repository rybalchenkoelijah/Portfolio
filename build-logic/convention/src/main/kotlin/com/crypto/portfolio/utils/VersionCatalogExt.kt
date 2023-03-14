package com.crypto.portfolio.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency


context(Project)
val versionCatalog get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

context(Project)
fun library(alias: String): Provider<MinimalExternalModuleDependency> = versionCatalog.findLibrary(alias).get()

context(Project)
fun bundle(alias: String): Provider<ExternalModuleDependencyBundle> = versionCatalog.findBundle(alias).get()

context(Project)
fun version(alias: String): String = versionCatalog.findVersion(alias).get().toString()

context(Project)
fun plugin(alias: String): Provider<PluginDependency> = versionCatalog.findPlugin(alias).get()