package compose.architect.practice.navigation

sealed class Navigation(val route: String) {
    data object Home : Navigation(HOME)
    data object Setting : Navigation(SETTING)

    companion object {
        private const val HOME = "HOME"
        private const val SETTING = "SETTING"
    }
}