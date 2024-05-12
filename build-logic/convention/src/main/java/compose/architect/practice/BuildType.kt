package compose.architect.practice

/**
 * This is shared between :app module to provide configurations type safety.
 */
enum class BuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}