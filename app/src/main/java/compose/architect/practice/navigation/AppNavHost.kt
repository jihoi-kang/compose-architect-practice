package compose.architect.practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import compose.architect.practice.feature.home.HomeScreen
import compose.architect.practice.feature.setting.SettingScreen

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.Home.route
    ) {
        composable(Navigation.Home.route) {
            HomeScreen()
        }
        composable(Navigation.Setting.route) {
            SettingScreen()
        }
    }
}