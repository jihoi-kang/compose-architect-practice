import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "compose.architect.practice.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.firebase.crashlytics.gradle.plugin)
    compileOnly(libs.firebase.performance.gradle.plugin)
    compileOnly(libs.room.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "architect.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidCompose") {
            id = "architect.android.compose"
            implementationClass = "AndroidComposePlugin"
        }
        register("androidFeature") {
            id = "architect.android.feature"
            implementationClass = "AndroidFeaturePlugin"
        }
        register("androidLibrary") {
            id = "architect.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidFirebase") {
            id = "architect.android.firebase"
            implementationClass = "AndroidFirebasePlugin"
        }
        register("androidRoom") {
            id = "architect.android.room"
            implementationClass = "AndroidRoomPlugin"
        }
    }
}