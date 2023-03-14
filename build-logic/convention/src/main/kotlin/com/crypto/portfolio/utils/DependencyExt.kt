package com.crypto.portfolio.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

context(Project, DependencyHandlerScope)
fun implementation(dependency: String): Dependency? {
    return add("implementation", library(dependency))
}

context(Project, DependencyHandlerScope)
fun implementationBom(dependency: String): Dependency? {
    return add("implementation", platform(library(dependency)))
}

context(Project, DependencyHandlerScope)
fun implementationBundle(dependency: String): Dependency? {
    return add("implementation", bundle(dependency))
}

context(Project, DependencyHandlerScope)
fun debugImplementation(dependency: String): Dependency? {
    return add("debugImplementation", library(dependency))
}

context(Project, DependencyHandlerScope)
fun debugImplementationBom(dependency: String): Dependency? {
    return add("debugImplementation", platform(library(dependency)))
}

context(Project, DependencyHandlerScope)
fun debugImplementationBundle(dependency: String): Dependency? {
    return add("debugImplementation", bundle(dependency))
}