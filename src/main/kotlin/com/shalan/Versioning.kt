package com.shalan

import com.shalan.utils.executeCommandLine
import com.shalan.utils.hasGit
import org.gradle.api.Project
import java.text.SimpleDateFormat
import java.util.*

open class Versioning {


    internal var project: Project? = null

    val versionCode: Int
        get() = getLastCommitId().also {
            println("${Versioning::class.java.simpleName}: generated version code ==> $it")
        }


    private fun getLastCommitId(): Int = project?.let {
        if (project?.hasGit() == true) {
            "git log -1 --format=%ct".executeCommandLine(it)?.toIntOrNull() ?: getCurrentDate()
        } else {
            getCurrentDate()
        }
    } ?: getCurrentDate()

    private fun getCurrentDate(): Int = SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Date()).toInt()
}