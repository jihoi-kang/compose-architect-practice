import compose.architect.practice.setNamespace

plugins {
    alias(libs.plugins.architect.android.library)
    alias(libs.plugins.architect.android.compose)
}

android {
    setNamespace("core.designsystem")
}