import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidPresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("llamasoft.android.library")
        pluginManager.apply("llamasoft.android.compose")
        pluginManager.apply("llamasoft.library.jacoco")
        pluginManager.apply("org.jetbrains.kotlin.android")
        //pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        dependencies {
            libs.findBundle("presentation-base").map {
                add("implementation", it)
            }
        }
    }
}
