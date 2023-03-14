package com.crypto.portfolio.utils

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(provider: Provider<MinimalExternalModuleDependency>) {
    add("implementation", provider)
}

fun DependencyHandlerScope.debugImplementation(provider: Provider<MinimalExternalModuleDependency>) {
    add("debugImplementation", provider)
}