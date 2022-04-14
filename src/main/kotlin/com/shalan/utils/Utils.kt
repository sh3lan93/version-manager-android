package com.shalan.utils

import org.gradle.api.Project
import java.io.ByteArrayOutputStream


fun String.executeCommandLine(project: Project): String? = try {
    ByteArrayOutputStream().use { outputStream ->
        project.exec {
            workingDir = project.rootProject.rootDir
            commandLine(this@executeCommandLine.split(" ")).apply {
                standardOutput = outputStream
            }
        }
        outputStream.toString().trim()
    }
} catch (exception: Exception) {
    println("There is an exception: ${exception.localizedMessage}")
    exception.printStackTrace()
    null
}

fun Project.hasGit(): Boolean = "git rev-parse --is-inside-work-tree".executeCommandLine(project) == true.toString()