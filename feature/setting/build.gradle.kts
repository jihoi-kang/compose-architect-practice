import compose.architect.practice.setNamespace

plugins {
    alias(libs.plugins.architect.android.feature)
}

android {
    setNamespace("feature.setting")
}
