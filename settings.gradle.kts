pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "compose-architect-practice"
include(":app")

// core
include(
    ":core:common",
    ":core:analytics",
    ":core:domain",
    ":core:designsystem",
    ":core:ui",
)

// feature
include(
    ":feature:home",
    ":feature:setting",
)
