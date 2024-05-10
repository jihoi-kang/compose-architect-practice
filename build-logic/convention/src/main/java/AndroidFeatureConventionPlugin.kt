import com.android.build.gradle.LibraryExtension
import compose.architect.practie.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("architect.android.library")
                apply("architect.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true // 테스트 중 애니메이션을 비활성화
            }

            dependencies {
//                add("implementation", project(":core:ui"))
//                add("implementation", project(":core:designsystem"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime-compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModel-compose").get())
                add("implementation", libs.findLibrary("androidx.tracing.ktx").get())

                add(
                    "androidTestImplementation",
                    libs.findLibrary("androidx.lifecycle.runtime-testing").get()
                )
            }
        }
    }
}