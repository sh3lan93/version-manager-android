import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option


class VersionNameChangerTask : DefaultTask() {

    @get:Input
    var versionName = "1.0.0"
        set(value) {
            println("the old value is $field and the new value is $value")
            field = value
        }

    @get:Input
    @Option(option = "version-name-suffix", description = "appended string at the end of the version name")
    var versionNameSuffix: String? = null

    @get:Input
    @Option(option = "version-name", description = "Desired version name")
    var inputVersionName: String? = null


    @TaskAction
    fun changeVersionName(): String = when {
        inputVersionName != null && versionNameSuffix != null -> "${inputVersionName}-${versionNameSuffix}"
        inputVersionName != null && versionNameSuffix == null -> "$inputVersionName"
        inputVersionName == null && versionNameSuffix != null -> "${versionName}-${versionNameSuffix}"
        else -> versionName
    }
}