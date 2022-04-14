import com.android.build.gradle.AppExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

fun Project.android(): AppExtension? = extensions.findByType()


fun Project.isAndroid(): Boolean = extensions.findByType<AppExtension>() != null