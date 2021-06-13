import com.android.build.gradle.BaseExtension
import com.shalan.VersionManagerPlugin
import org.gradle.api.GradleException
import org.gradle.api.Project

fun Project.android(): BaseExtension {
    return extensions.findByType(BaseExtension::class.java)
        ?: throw GradleException("This plugin ${VersionManagerPlugin::class.java.simpleName} only applied to android projects")
}
