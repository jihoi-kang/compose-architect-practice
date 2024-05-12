import compose.architect.practice.configureComposeAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configureComposeAndroid()
    }
}