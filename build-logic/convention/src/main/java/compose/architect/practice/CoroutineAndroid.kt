package compose.architect.practice

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineAndroid() {
    dependencies {
        implementation(libs.findLibrary("coroutines.android").get())
        implementation(libs.findLibrary("coroutines.core").get())
        testImplementation(libs.findLibrary("coroutines.test").get())
    }
}