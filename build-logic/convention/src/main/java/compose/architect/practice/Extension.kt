package compose.architect.practice

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import compose.architect.practice.Const.PACKAGE_NAME
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

/** Dependency Handler Scope Extension */
fun DependencyHandler.implementation(provider: Provider<MinimalExternalModuleDependency>) {
    this.add("implementation", provider)
}

fun DependencyHandler.implementation(project: Project) {
    this.add("implementation", project)
}

fun DependencyHandler.ksp(provider: Provider<MinimalExternalModuleDependency>) {
    this.add("ksp", provider)
}

fun DependencyHandler.androidTestImplementation(provider: Provider<MinimalExternalModuleDependency>) {
    this.add("androidTestImplementation", provider)
}

fun DependencyHandler.debugImplementation(provider: Provider<MinimalExternalModuleDependency>) {
    this.add("debugImplementation", provider)
}

fun DependencyHandler.testImplementation(provider: Provider<MinimalExternalModuleDependency>) {
    this.add("testImplementation", provider)
}

/** Project Extension */
fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "${PACKAGE_NAME}.${name}"
    }
}

internal val Project.androidExtension: CommonExtension<*, *, *, *, *, *>
    get() = runCatching { libraryExtension }
        .recoverCatching { applicationExtension }
        .onFailure { println("[Build Failure] Could not find Library or Application extension from this project") }
        .getOrThrow()

internal val Project.libraryExtension: CommonExtension<*, *, *, *, *, *>
    get() = extensions.getByType<LibraryExtension>()

internal val Project.applicationExtension: CommonExtension<*, *, *, *, *, *>
    get() = extensions.getByType<ApplicationExtension>()

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")