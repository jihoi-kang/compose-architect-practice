import compose.architect.practice.androidExtension
import compose.architect.practice.configureHiltAndroid
import compose.architect.practice.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


class AndroidFeaturePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("architect.android.library")
                apply("architect.android.compose")
            }

            androidExtension.apply {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }

            configureHiltAndroid()

            dependencies {
                implementation(project(":core:common"))
            }
        }
    }
}