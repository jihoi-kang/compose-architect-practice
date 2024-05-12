import compose.architect.practice.setNamespace

plugins {
    alias(libs.plugins.architect.android.library)
}

android {
    setNamespace("core.common")
}