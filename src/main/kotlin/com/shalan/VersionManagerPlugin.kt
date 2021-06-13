package com.shalan

import android
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.ByteArrayOutputStream
import java.util.*

class VersionManagerPlugin : Plugin<Project> {

    companion object {
        var VERSION_CODE = 1
        private const val ANDROID_RELEASE_BUILD_TYPE = "release"
        private const val ANDROID_DEBUG_BUILD_TYPE = "debug"
        private const val TASK_NAME = "versionCodeChanger"
        private const val TASK_GROUP_NAME = "Versioning"
    }

    override fun apply(target: Project) {
        target.android().apply {
            this.buildTypes.forEach {
                when (it.name) {
                    ANDROID_RELEASE_BUILD_TYPE -> registerReleaseVersionCodeChanger(project = target)
                    ANDROID_DEBUG_BUILD_TYPE -> registerDebugVersionCodeChanger(project = target)
                    else -> throw GradleException("This type ${it.name} is unsupported")
                }
            }
        }
    }

    private fun registerReleaseVersionCodeChanger(project: Project) {
        project.tasks.create(TASK_NAME) {
            group = TASK_GROUP_NAME
            project.exec {
                ByteArrayOutputStream().use { output ->
                    try {
                        commandLine("git", "log", "-1", "--format=%ct").apply {
                            standardOutput = output
                        }
                        VERSION_CODE = output.toString().trim().toInt()
                    } catch (e: Exception) {
                        println("There is an exception happened ${e.localizedMessage}")
                        e.printStackTrace()
                        println("The version code has been changed to reflect the timestamp of the build")
                        VERSION_CODE = (Date().time / 1000).toInt()
                    }
                }
            }
        }
    }

    private fun registerDebugVersionCodeChanger(project: Project) {
        VERSION_CODE = (Date().time / 1000).toInt()
    }

}