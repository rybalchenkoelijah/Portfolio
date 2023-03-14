/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crypto.portfolio

import com.android.build.api.dsl.CommonExtension
import com.crypto.portfolio.utils.ProjectScope
import com.crypto.portfolio.utils.implementation
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import java.io.File

/**
 * Configure Compose-specific options
 */
fun ProjectScope<*,*,*,*>.configureAndroidCompose() {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = findVersion("compose-compiler").get().toString()
    }

    dependencies {
        val bom = findLibrary("compose-bom").get()

        add("implementation", platform(bom))
        add("implementation", findBundle("compose").get())
        add("debugImplementation", findLibrary("compose-ui-tooling").get())
    }
}
