package compose.architect.practice

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {
    with(pluginManager) {
        apply("dagger.hilt.android.plugin")
        apply("com.google.devtools.ksp")
    }

    dependencies {
        implementation(libs.findLibrary("hilt.android").get())
        ksp(libs.findLibrary("hilt.android.compiler").get())
    }
}