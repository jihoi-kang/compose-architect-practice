import compose.architect.practice.configureCoroutineAndroid
import compose.architect.practice.configureHiltAndroid
import compose.architect.practice.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            configureKotlinAndroid()
            configureCoroutineAndroid()
            configureHiltAndroid()
        }
    }
}