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

import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.ProductFlavor
import com.crypto.portfolio.utils.debugImplementation
import com.crypto.portfolio.utils.implementationBom
import com.crypto.portfolio.utils.implementationBundle
import com.crypto.portfolio.utils.version
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
context(Project, CommonExtension<BF, BT, DC, PF>)
fun <BF : BuildFeatures, BT : BuildType, DC : DefaultConfig, PF : ProductFlavor> configureAndroidCompose() {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = version("compose-compiler")
    }

    dependencies {
        implementationBom("compose-bom")
        implementationBundle("compose")
        debugImplementation("compose-ui-tooling")
    }
}
