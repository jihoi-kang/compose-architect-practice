import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import compose.architect.practice.androidExtension
import compose.architect.practice.implementation
import compose.architect.practice.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFirebasePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.gms.google-services")
                apply("com.google.firebase.firebase-perf")
                apply("com.google.firebase.crashlytics")
            }

            dependencies {
                val bom = libs.findLibrary("firebase-bom").get()
                implementation(platform(bom))
                implementation(libs.findLibrary("firebase.analytics").get())
                implementation(libs.findLibrary("firebase.performance").get())
                implementation(libs.findLibrary("firebase.crashlytics").get())
            }

            androidExtension.apply {
                buildTypes.configureEach {
                    // Disable the Crashlytics mapping file upload. This feature should only be
                    // enabled if a Firebase backend is available and configured in
                    // google-services.json.
                    configure<CrashlyticsExtension> {
                        mappingFileUploadEnabled = false
                    }
                }
            }
        }
    }
}