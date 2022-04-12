import com.android.build.gradle.AppExtension
import com.shalan.VersionManagerPlugin
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

fun Project.android(): AppExtension {
    return extensions.findByType()
        ?: throw GradleException("This plugin ${VersionManagerPlugin::class.java.simpleName} only applied to android projects")
}
