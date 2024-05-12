import compose.architect.practice.BuildType

plugins {
    alias(libs.plugins.architect.android.application)
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    namespace = "compose.architect.practice"

    defaultConfig {
        applicationId = "compose.architect.practice"
        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        debug {
            applicationIdSuffix = BuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = false
            applicationIdSuffix = BuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.common)
}