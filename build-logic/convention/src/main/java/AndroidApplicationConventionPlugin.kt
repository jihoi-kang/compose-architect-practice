import com.android.build.api.dsl.ApplicationExtension
import compose.architect.practie.Config.ANDROID_TARGET_SDK
import compose.architect.practie.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = ANDROID_TARGET_SDK
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true // 테스트 중 애니메이션을 비활성화
            }
        }
    }
}