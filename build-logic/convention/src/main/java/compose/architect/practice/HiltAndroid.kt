package compose.architect.practice

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {
    with(pluginManager) {
        apply("com.google.devtools.ksp")
        apply("dagger.hilt.android.plugin")
    }

    dependencies {
        implementation(libs.findLibrary("hilt.android").get())
        ksp(libs.findLibrary("hilt.android.compiler").get())
    }
}