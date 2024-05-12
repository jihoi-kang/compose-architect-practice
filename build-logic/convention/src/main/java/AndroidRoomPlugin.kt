import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import compose.architect.practice.implementation
import compose.architect.practice.ksp
import compose.architect.practice.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.devtools.ksp")
                apply("androidx.room")
            }

            extensions.configure<KspExtension> {
                arg("room.generateKotlin", "true")
            }

            extensions.configure<RoomExtension> {
                // The schemas directory contains a schema file for each version of the Room database.
                // This is required to enable Room auto migrations.
                // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                implementation(libs.findLibrary("room.runtime").get())
                implementation(libs.findLibrary("room.ktx").get())
                ksp(libs.findLibrary("room.compiler").get())
            }
        }
    }
}