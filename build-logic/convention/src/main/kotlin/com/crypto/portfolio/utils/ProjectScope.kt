package com.crypto.portfolio.utils

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.ProductFlavor
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class ProjectScope<BF : BuildFeatures, BT : BuildType, DC : DefaultConfig, PF : ProductFlavor> constructor(
    project: Project,
    extension: CommonExtension<BF, BT, DC, PF>,
) : Project by project,
    VersionCatalog by project.extensions.getByType<VersionCatalogsExtension>().named("libs"),
    CommonExtension<BF, BT, DC, PF> by extension {

    override fun getName(): String = project.name

    companion object {
        inline fun <BF : BuildFeatures, BT : BuildType, DC : DefaultConfig, PF : ProductFlavor> Project.withExtension(
            extension: CommonExtension<BF, BT, DC, PF>,
            block: ProjectScope<BF, BT, DC, PF>.() -> Unit
        ) {
            ProjectScope(this, extension).block()
        }

        inline fun <reified E: CommonExtension<*,*,*,*>> Project.withExtension(
            block: ProjectScope<*,*,*,*>.() -> Unit
        ) {
            withExtension(extensions.getByType<E>(),block)
        }
    }
}