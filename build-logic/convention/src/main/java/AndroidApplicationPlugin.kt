import org.gradle.api.Plugin
import org.gradle.api.Project
import compose.architect.practice.configureHiltAndroid
import compose.architect.practice.configureKotlinAndroid

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")

            configureKotlinAndroid()
            configureHiltAndroid()
        }
    }

}