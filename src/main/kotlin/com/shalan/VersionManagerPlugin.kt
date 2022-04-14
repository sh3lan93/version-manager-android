package com.shalan

import android
import org.gradle.api.Plugin
import org.gradle.api.Project

class VersionManagerPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.android()?.apply {
            target.extensions.create("androidVersioning", Versioning::class.java).apply {
                project = target
            }
        }
    }

}